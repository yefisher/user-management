package com.eanimal.usermanagerservice.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.eanimal.usermanagerservice.api.exception.EntityNotFoundException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class GlobalErrorHandlerTest {

  private final GlobalErrorHandler testable = new GlobalErrorHandler();

  @Test
  public void shouldHandleEntityNotFoundExceptionThenReturnNotFound() {
    var randomId = UUID.randomUUID();
    var response = testable.handle(new EntityNotFoundException("Entity not found: %s", randomId));
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }

  @Test
  public void shouldHandleIllegalArgumentExceptionThemReturnBadRequest() {
    var response = testable.handle(new IllegalArgumentException());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldHandleOtherExceptionThenReturnServiceUnavailable() {
    var response = testable.handle(new NullPointerException());
    assertEquals(HttpStatus.SERVICE_UNAVAILABLE, response.getStatusCode());
  }
}
