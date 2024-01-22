package com.kycapp.clm.workflow.service.Impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kycapp.clm.workflow.entity.CaseType;
import com.kycapp.clm.workflow.repository.CaseTypeRepository;
import com.kycapp.clm.workflow.service.ICaseTypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CaseTypeServiceImpl implements ICaseTypeService{

    CaseTypeRepository caseTypeRepository;
    @Override
    public CaseType get(int id) {
        Optional<CaseType> caseTypeOptional = caseTypeRepository.findById(id);
        return caseTypeOptional.orElseThrow(() -> new RuntimeException("Data not found in Case table"));
    }
    
    @Override
    public CaseType save(CaseType caseType) {
        return caseTypeRepository.save(caseType);
    }
}
