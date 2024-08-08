package com.eanimal.usermanagerservice.domain;

import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
