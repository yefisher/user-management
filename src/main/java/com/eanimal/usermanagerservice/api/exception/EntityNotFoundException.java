package com.eanimal.usermanagerservice.api.exception;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(String msg, Object... other) {
    super(String.format(msg, other));
  }
}
