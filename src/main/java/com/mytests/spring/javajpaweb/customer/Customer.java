package com.mytests.spring.javajpaweb.customer;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;
  String name;
  String email;

  @Embedded
  private AuditMetadata auditingMetadata;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AuditMetadata getAuditingMetadata() {
    return auditingMetadata;
  }

  public void setAuditingMetadata(AuditMetadata auditingMetadata) {
    this.auditingMetadata = auditingMetadata;
  }

  @Override
  public String toString() {
    if (auditingMetadata == null) {return "Customer{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", email='" + email + '\'' +
           ", createdAt=null" +
           ", updatedAt=null" +
           '}';}
    else {
        return "Customer{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", createdAt=" + auditingMetadata.getCreatedDate() +
               ", updatedAt=" + auditingMetadata.getLastModifiedDate() +
               '}';}
  }
}

