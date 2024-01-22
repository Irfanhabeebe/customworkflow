package com.kycapp.clm.workflow.service;

import com.kycapp.clm.businessPartner.entity.BusinessPartner;

public interface ICaseService {

    public void startWorkflow(BusinessPartner businessPartner, int caseTypeId);
    
}
