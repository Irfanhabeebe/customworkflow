package com.kycapp.clm.workflow.service.Impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kycapp.clm.workflow.entity.TaskConfig;
import com.kycapp.clm.workflow.repository.TaskConfigRepository;
import com.kycapp.clm.workflow.service.ITaskConfigService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskConfigServiceImpl implements ITaskConfigService {

    TaskConfigRepository taskConfigRepository;

    @Override
    public TaskConfig get(int id) {
        Optional<TaskConfig> taskConfigOptional = taskConfigRepository.findById(id);
        return taskConfigOptional.orElseThrow(() -> new RuntimeException("Data not found in task config"));

    }

    @Override
    public TaskConfig save(TaskConfig taskConfig) {
        return taskConfigRepository.save(taskConfig);
    }
    
}
