package com.eanimal.usermanagerservice.api.request;

import java.time.Instant;
import lombok.Builder;
import lombok.Value;

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
