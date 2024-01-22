package com.kycapp.clm.businessPartner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kycapp.clm.businessPartner.entity.BusinessPartner;

@Repository
public interface BusinessPartnerRepository extends JpaRepository<BusinessPartner, Long>{

    
}
