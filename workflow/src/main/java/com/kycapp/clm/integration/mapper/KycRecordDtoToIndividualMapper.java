package com.kycapp.clm.integration.mapper;

import org.springframework.stereotype.Component;

import com.kycapp.clm.businessPartner.entity.Individual;
import com.kycapp.clm.fileProcess.dto.KycRefreshFileDto;

@Component
public class KycRecordDtoToIndividualMapper {
    public Individual mapToIndividual(KycRefreshFileDto kycRefreshFileDto){
        Individual individual = new Individual();
        individual.setBusinessUnit(kycRefreshFileDto.getBusinessUnit());
        individual.setCifCode(kycRefreshFileDto.getCifNumber());
        if (kycRefreshFileDto.getDirestCustFlag().equals("Y")) individual.setDirectCustomerFlag(true);
        else individual.setDirectCustomerFlag(false);
        individual.setFirstName(kycRefreshFileDto.getFirstName());
        individual.setLastName(kycRefreshFileDto.getLastName());
        individual.setMiddleName(kycRefreshFileDto.getMiddleName());
        if (kycRefreshFileDto.getBusinessPartnerName().isEmpty() || kycRefreshFileDto.getBusinessPartnerName().isBlank()){
            individual.setName(kycRefreshFileDto.getFirstName() + " " + kycRefreshFileDto.getMiddleName() + " " + kycRefreshFileDto.getLastName());
        }else{
            individual.setName(kycRefreshFileDto.getBusinessPartnerName());
        }
        individual.setPartySubType(kycRefreshFileDto.getPartySubType());
        individual.setPartyType(kycRefreshFileDto.getPartyType());
        individual.setRiskRating(kycRefreshFileDto.getRiskRating());
        return individual;
    }
}
