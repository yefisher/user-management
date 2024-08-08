package com.eanimal.usermanagerservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class User extends UserTelemetry {
  @Id UUID id;

  String firstName;
  String LastName;

  @Column(nullable = false)
  String userEmail;

  @Column(nullable = false)
  String username;

  String encodedPassword;
  Instant lastPasswordUpdateDate;

  Instant birthDate;
  String role;
  String about;

  Boolean isMailingEnabled;
}
