package com.eanimal.usermanagerservice.api.request;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class UserRequest {
  String firstName;
  String lastName;

  String userEmail;
  String username;

  String pwd;

  Instant birthDate;
  String about;

  Boolean isMailingEnabled;
}