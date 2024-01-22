package com.kycapp.clm.workflow.mapper;

import org.springframework.stereotype.Component;

import com.kycapp.clm.workflow.entity.Stage;
import com.kycapp.clm.workflow.entity.Task;
import com.kycapp.clm.workflow.entity.TaskConfig;

@Component
public class TaskMapper {

    public Task mapToTask(TaskConfig taskConfig, Stage stage){
        Task task = new Task();
        task.setStage(stage);
        task.setTaskOrder(taskConfig.getTaskOrder());
        task.setTaskConfigId(taskConfig.getTaskConfigId());
        task.setTaskName(taskConfig.getTaskName());
        task.setDescription(taskConfig.getDescription());
        task.setTaskStatus(1);
        task.setCaseId(stage.getCase1().getCaseId());
        task.setTaskRenderExecutable(taskConfig.getTaskRenderExecutable());
        task.setTaskRenderDTO(taskConfig.getTaskRenderDTO());
        task.setTaskTriggerCondition(taskConfig.getTaskTriggerCondition());
        task.setTaskSubmitExecutable(taskConfig.getTaskSubmitExecutable());
        task.setTaskSubmitDTO(taskConfig.getTaskSubmitDTO());
        return task;
    }
    
}
