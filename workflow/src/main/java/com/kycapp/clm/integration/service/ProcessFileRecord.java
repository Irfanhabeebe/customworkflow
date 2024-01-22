package com.kycapp.clm.integration.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.kycapp.clm.businessPartner.entity.Individual;
import com.kycapp.clm.businessPartner.service.IIndividualService;
import com.kycapp.clm.fileProcess.dto.KycRefreshFileDto;
import com.kycapp.clm.integration.mapper.KycRecordDtoToIndividualMapper;
import com.kycapp.clm.workflow.entity.Task;
import com.kycapp.clm.workflow.service.ICaseService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProcessFileRecord {

    KycRecordDtoToIndividualMapper kycRecordDtoToIndividualMapper;
    IIndividualService individualService;
    ICaseService caseService;

    @Async("customTaskExecutor")
    @Transactional
    public Future<Void> processKycRefreshRecord(KycRefreshFileDto kycRefreshFileDto) {
        Individual individual =kycRecordDtoToIndividualMapper.mapToIndividual(kycRefreshFileDto);
        individual = individualService.save(individual);
        caseService.startWorkflow(individual,1);
        return CompletableFuture.completedFuture(null);
    }
}
