package com.kycapp.clm.workflow.service;

import com.kycapp.clm.workflow.entity.StageConfig;

public interface IStageConfigService {

    public StageConfig save(StageConfig stageConfig);
    public StageConfig get(int id);
  
}
