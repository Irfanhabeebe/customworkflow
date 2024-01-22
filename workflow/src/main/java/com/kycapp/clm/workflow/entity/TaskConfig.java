package com.kycapp.clm.workflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
public class TaskConfig {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskConfigId;

    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name = "stageConfigId", referencedColumnName = "stageConfigId")
    private StageConfig stageConfig;

    @NonNull
    @Column
    private String taskName;

    @Column
    private String description;

    @NonNull
    @Column
    private String taskExecutable;

    @NonNull
    @Column
    private Integer taskOrder;

    @NonNull
    @Column
    private Integer taskType; // 1 - System Task, 2 UserTask

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

    private TaskConfig(Builder builder) {
        this.taskName = builder.taskName;
        this.description = builder.description;

    }

    public static class Builder {

        private String taskName;
        private String description;
        private String taskExecutable;
        private Integer taskOrder;
        private Integer taskType; // 1 - System Task, 2 UserTask
        private String taskTriggerCondition;
        private String taskRenderExecutable;
        private String taskRenderDTO;
        private String taskSubmitExecutable;
        private String taskSubmitDTO;

        public  Builder(String taskName) {
            this.taskName = taskName;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder taskExecutable(String taskExecutable) {
            this.taskExecutable = taskExecutable;
            return this;
        }

        public Builder taskOrder(int taskOrder) {
            this.taskOrder = taskOrder;
            return this;
        }

        public Builder taskType(int taskType) {
            this.taskType = taskType;
            return this;
        }

        public Builder taskTriggerCondition(String descriptaskTriggerConditiontion) {
            this.taskTriggerCondition = taskTriggerCondition;
            return this;
        }

        public Builder taskRenderExecutable(String taskRenderExecutable) {
            this.taskRenderExecutable = taskRenderExecutable;
            return this;
        }

        public Builder taskRenderDTO(String taskRenderDTO) {
            this.taskRenderDTO = taskRenderDTO;
            return this;
        }

        public Builder taskSubmitExecutable(String taskSubmitExecutable) {
            this.taskSubmitExecutable = taskSubmitExecutable;
            return this;
        }

        public Builder taskSubmitDTO(String taskSubmitDTO) {
            this.taskSubmitDTO = taskSubmitDTO;
            return this;
        }

        // Add setter methods for other optional attributes

        // Build method to create the Task object
        public TaskConfig build() {
            return new TaskConfig(this);
        }
    }

}
