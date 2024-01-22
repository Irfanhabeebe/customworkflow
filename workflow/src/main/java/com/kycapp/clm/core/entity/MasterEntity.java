package com.kycapp.clm.core.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class MasterEntity {

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdTime;

    @LastModifiedBy
    private String lasteUpdatedBy;

    @LastModifiedDate
    private LocalDateTime lastUpdatedTime;

    @Version
    private int version;

//    @Version
//    private String version; -- This needs to be implemented to stop concurrent updates.

@PrePersist
public void onCreate() {
    this.createdTime = LocalDateTime.now(ZoneId.of("UTC"));
    this.lastUpdatedTime = LocalDateTime.now(ZoneId.of("UTC"));
}

@PreUpdate
public void onUpdate() {
    this.lastUpdatedTime = LocalDateTime.now(ZoneId.of("UTC"));
}

    
}
