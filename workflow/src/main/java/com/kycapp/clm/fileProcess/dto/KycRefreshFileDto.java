package com.kycapp.clm.fileProcess.dto;

import org.springframework.context.annotation.Primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class KycRefreshFileDto {
    private String recordType;
    private String cifNumber;
    private String parentCifNumber;
    private String businessPartnerName;
    private String partyTypeCode;
    private String partyType;
    private String partySubType;
    private String businessUnit;
    private String riskRating;
    private String firstName;
    private String lastName;
    private String middleName;
    private String direstCustFlag;
}
