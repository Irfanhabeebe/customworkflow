package com.kycapp.clm.workflow.repository;

import org.springframework.data.repository.CrudRepository;

import com.kycapp.clm.workflow.entity.Case;

public interface CaseRepository extends CrudRepository<Case, Long> {
    
}
