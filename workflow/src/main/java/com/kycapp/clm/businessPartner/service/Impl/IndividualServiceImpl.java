package com.kycapp.clm.businessPartner.service.Impl;

import org.springframework.stereotype.Service;

import com.kycapp.clm.businessPartner.entity.Individual;
import com.kycapp.clm.businessPartner.repository.IndividualRepository;
import com.kycapp.clm.businessPartner.service.IIndividualService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndividualServiceImpl implements IIndividualService{

    IndividualRepository individualRepository;
    public Individual save(Individual individual) {
        return individualRepository.save(individual);  
    }
}
