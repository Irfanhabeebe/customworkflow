package com.kycapp.clm.workflow.service;

import com.kycapp.clm.workflow.entity.CaseType;

public interface ICaseTypeService {

    public CaseType save(CaseType caseType);
    public CaseType get(int id);
    
}
