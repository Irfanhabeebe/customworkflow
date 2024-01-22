package com.kycapp.clm.workflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kycapp.clm.workflow.entity.TaskConfig;

@Repository
public interface TaskConfigRepository extends CrudRepository<TaskConfig,Integer> {

    
}
