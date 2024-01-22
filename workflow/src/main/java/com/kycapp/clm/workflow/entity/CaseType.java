package com.kycapp.clm.workflow.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@RequiredArgsConstructor@NoArgsConstructor
@Entity
public class CaseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int caseTypeId; //1 Onboarding

    @Column
    @NonNull
    private String caseName; 

    @OneToMany(mappedBy =  "caseType", cascade = CascadeType.ALL)
    private List<StageConfig> caseStageConfigs;
    
    @Version
    private int version;

}
