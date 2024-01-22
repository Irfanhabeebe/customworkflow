package com.kycapp.clm.workflow.service.Impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kycapp.clm.workflow.entity.StageConfig;
import com.kycapp.clm.workflow.repository.StageConfigRepository;
import com.kycapp.clm.workflow.service.IStageConfigService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StageConfigServiceImpl implements IStageConfigService{

    StageConfigRepository stageConfigRepository;
    @Override
    public StageConfig get(int id) {
        Optional<StageConfig> sOptional = stageConfigRepository.findById(id);
        return sOptional.orElseThrow(() -> new RuntimeException("Data not found in Stage Config"));
    }

    @Override
    public StageConfig save(StageConfig stageConfig) {
        return stageConfigRepository.save(stageConfig);
    }
}
