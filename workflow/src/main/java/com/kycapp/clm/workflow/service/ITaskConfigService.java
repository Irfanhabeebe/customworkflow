package com.kycapp.clm.workflow.service;

import com.kycapp.clm.workflow.entity.TaskConfig;

public interface ITaskConfigService {
  
    public TaskConfig save(TaskConfig taskConfig);
    public TaskConfig get(int id);
}
