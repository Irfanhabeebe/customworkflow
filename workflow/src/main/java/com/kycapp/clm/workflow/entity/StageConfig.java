package com.kycapp.clm.workflow.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@RequiredArgsConstructor
@Entity
public class StageConfig {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stageConfigId;

    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name="caseTypeId", referencedColumnName = "caseTypeId")
    private CaseType caseType;

    @NonNull
    @Column
    private String stageName;

    @NonNull
    @Column
    private Integer parentStageConfigId;

    @OneToMany(mappedBy =  "stageConfig", cascade = CascadeType.ALL)
    private List<TaskConfig> taskConfigurations ;

}
