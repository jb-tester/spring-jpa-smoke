package com.mytests.spring.javajpaweb.customer;

import jakarta.persistence.Embeddable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Embeddable
public class AuditMetadata {

  @LastModifiedDate
  Instant lastModifiedDate;

  @CreatedDate
  private Instant createdDate;

  public Instant getLastModifiedDate() {
    return lastModifiedDate;
  }

  public void setLastModifiedDate(Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public Instant getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Instant createdDate) {
    this.createdDate = createdDate;
  }
}