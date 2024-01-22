package com.kycapp.clm.workflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kycapp.clm.workflow.entity.Case;
import com.kycapp.clm.workflow.entity.Task;

import java.util.List;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
    
    List<Task> findByTaskStatus(Integer taskStatus);
    List<Task> findByCaseIdAndTaskOrder(Long caseId,Integer taskorder);
}