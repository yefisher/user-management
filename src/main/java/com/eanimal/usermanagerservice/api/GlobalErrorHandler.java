package com.eanimal.usermanagerservice.api;

import com.eanimal.usermanagerservice.api.exception.EntityNotFoundException;
import com.eanimal.usermanagerservice.api.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handle(Exception ex) {
    HttpStatus status =
        ex instanceof IllegalArgumentException
            ? HttpStatus.BAD_REQUEST
            : ex instanceof EntityNotFoundException
                ? HttpStatus.NOT_FOUND
                : HttpStatus.SERVICE_UNAVAILABLE;

    return ResponseEntity.status(status).body(new ErrorResponse(ex.getMessage(), status));
  }
}
