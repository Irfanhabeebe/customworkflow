package com.kycapp.clm.workflow.mapper;

import org.springframework.stereotype.Component;

import com.kycapp.clm.workflow.entity.Case;
import com.kycapp.clm.workflow.entity.CaseType;

@Component
public class CaseMapper {

    public Case mapToCase(CaseType caseType){
        Case case1 = new Case();
        case1.setCaseTypeId(caseType.getCaseTypeId());
        case1.setCaseName(caseType.getCaseName());
        case1.setCaseStatus(1);
        return case1;
    }
    
}
