package com.kycapp.clm.workflow.service.Impl;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.kycapp.clm.workflow.entity.Task;
import com.kycapp.clm.workflow.repository.TaskRepository;
import com.kycapp.clm.workflow.service.ITaskService;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private static final Logger logger =LogManager.getLogger();

    private TaskRepository taskRepository;
    private Queue queue;
	private RabbitTemplate rabbitTemplate;
    private ApplicationContext applicationContext;
    
    @Override
    public List<Task> getAllReadyTasksForExecution() {
        // TODO Auto-generated method stub
        return taskRepository.findByTaskStatus(2);
    }

    @Override
    @Async("customTaskExecutor")
    @Transactional
    public Future<Void> processTaskAsync(Task task) {
        // Implement task processing logic
        try{
        task.setTaskStatus(3);
        taskRepository.save(task);
        //System.out.println("Task with ID " + task.getTaskId() + " executed asynchronously.");
        Class<?> clazz = Class.forName(task.getTaskSubmitExecutable());
        Object beanInstance = applicationContext.getBean(clazz);
        Method runMethod = clazz.getMethod("run");
        runMethod.invoke(beanInstance);
        task.setTaskStatus(4);
        taskRepository.save(task);
        List<Task>nextTasks = taskRepository.findByCaseIdAndTaskOrder(task.getCaseId(),task.getTaskOrder()+1);
        for (Task task2 : nextTasks) {
            rabbitTemplate.convertAndSend(queue.getName(), task2);
        }  
    }catch (Exception e){
        throw new RuntimeException("Exception in Process Async");
    }
        return CompletableFuture.completedFuture(null);
    }

}
