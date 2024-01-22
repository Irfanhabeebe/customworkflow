package com.kycapp.clm.workflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kycapp.clm.workflow.entity.CaseType;

@Repository
public interface CaseTypeRepository extends CrudRepository<CaseType,Integer> {
    
}
