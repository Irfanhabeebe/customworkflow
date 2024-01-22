package com.kycapp.clm.businessPartner.entity;

import com.kycapp.clm.core.entity.MasterEntity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "partner_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BusinessPartner extends MasterEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessPartnerId;

    private String name;

    private String riskRating;

    private String partyType;

    private String partySubType;

    private String businessUnit;

    private boolean directCustomerFlag;

   // private String partnerType;

    // Other common fields and methods...

    // Getters and setters...
}
