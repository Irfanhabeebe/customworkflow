package com.kycapp.clm.workflow.entity;

import org.hibernate.type.descriptor.java.SerializableJavaType;

import com.kycapp.clm.core.entity.MasterEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
@NoArgsConstructor@RequiredArgsConstructor
@Entity
public class Task extends MasterEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TaskId;

    @Column
    private int taskConfigId;

    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name="stageId",referencedColumnName = "stageId")
    private Stage stage;

    @Column
    private long caseId;

    @NonNull
    @Column
    private String taskName;

    @Column
    private String description;

    @NonNull
    @Column
    private Integer taskOrder;

    @NonNull
    @Column
    private Integer taskStatus; //1 Waiting //2 Ready // 3 In Progress // 4 Complete 

    @NonNull
    @Column
    private Integer taskType; //1 - System Task, 2 UserTask

    @NonNull
    @Column
    private String taskTriggerCondition;

    @NonNull
    @Column
    private String taskRenderExecutable;

    @NonNull
    @Column
    private String taskRenderDTO;

    @NonNull
    @Column
    private String taskSubmitExecutable;

    @NonNull
    @Column
    private String taskSubmitDTO;

}
