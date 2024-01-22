package com.kycapp.clm.businessPartner.service;

import org.springframework.stereotype.Service;

import com.kycapp.clm.businessPartner.entity.Individual;

import lombok.AllArgsConstructor;

public interface IIndividualService {

    public Individual save (Individual individual);
    
}
