package com.eanimal.usermanagerservice.api.response;

import com.eanimal.usermanagerservice.domain.UserTelemetry;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Value
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class UserResponse extends UserTelemetry {
  UUID id;
  String firstName;
  String lastName;
  String username;
  String userEmail;
  Instant birthDate;
  String role;
  String about;
  String isMailingEnabled;
}
