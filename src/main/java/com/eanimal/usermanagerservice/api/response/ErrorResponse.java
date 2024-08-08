package com.eanimal.usermanagerservice.api.response;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ErrorResponse {
  String message;
  HttpStatus status;
}
