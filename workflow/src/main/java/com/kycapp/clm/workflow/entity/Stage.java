package com.kycapp.clm.workflow.entity;

import java.util.List;

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
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
public class Stage extends MasterEntity{

    @Id
    @Column 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long stageId;

    @Column
    private int stageConfigId;

    @Column
    private String stageName;

    @ManyToOne
    @JoinColumn(name="caseId", referencedColumnName = "caseId")
    private Case case1;

    @Column
    private int parentStageId;

    @Column
    private int status; //1  open, 2 complete

    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL )
    List<Task> tasks;


}
