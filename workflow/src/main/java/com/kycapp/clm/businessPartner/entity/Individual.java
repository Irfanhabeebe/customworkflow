package com.kycapp.clm.businessPartner.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Individual extends BusinessPartner {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String occupationCode;
    private String cifCode;
    private String businessUnit;
}
