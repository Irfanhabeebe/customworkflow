package com.kycapp.clm.workflow.entity;

import java.util.List;

import com.kycapp.clm.businessPartner.entity.BusinessPartner;
import com.kycapp.clm.core.entity.MasterEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "cases")  
public class Case extends MasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long caseId;

    @Column
    private int caseTypeId;

    @Column
    private String caseName;

    @Column
    private int caseStatus; //1 Open, 2 Complete

    @OneToMany(mappedBy = "case1", cascade = CascadeType.ALL)
    private List<Stage> stage;

    @ManyToOne 
    @JoinColumn(name="businessPartnerId", referencedColumnName="businessPartnerId")
    private BusinessPartner businessPartner;
}
