package com.kycapp.clm.workflow.service;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

import com.kycapp.clm.workflow.entity.Task;

public interface ITaskService {
   public List<Task> getAllReadyTasksForExecution ();

   @Async("customTaskExecutor")
   Future<Void> processTaskAsync(Task task);
}
