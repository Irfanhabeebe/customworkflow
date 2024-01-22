package com.kycapp.clm.workflow.mapper;

import org.springframework.stereotype.Component;

import com.kycapp.clm.workflow.entity.Case;
import com.kycapp.clm.workflow.entity.Stage;
import com.kycapp.clm.workflow.entity.StageConfig;

@Component
public class StageMapper {

    public Stage mapToStage(StageConfig stageConfig, Case case1){
        Stage stage = new Stage();
        stage.setCase1(case1);
        stage.setStageConfigId(stageConfig.getStageConfigId());
        stage.setStageName(stageConfig.getStageName());
        stage.setStatus(1);
        return stage;
    }
    
}
