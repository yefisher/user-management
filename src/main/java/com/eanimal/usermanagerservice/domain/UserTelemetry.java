package com.eanimal.usermanagerservice.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@MappedSuperclass
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode
public abstract class UserTelemetry {

  Instant creationDate;
  Instant lastUpdateDate;

  Instant activityLastDate;
  Boolean isDeleted;
}
