package com.kycapp.clm.workflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kycapp.clm.workflow.entity.Stage;

@Repository
public interface StageRepository extends CrudRepository<Stage,Long>{
    
}