package com.kycapp.clm.businessPartner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kycapp.clm.businessPartner.entity.Individual;

@Repository
public interface IndividualRepository extends CrudRepository<Individual,Long>{
    
}
