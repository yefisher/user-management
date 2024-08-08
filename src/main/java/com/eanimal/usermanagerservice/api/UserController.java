package com.eanimal.usermanagerservice.api;

import com.eanimal.usermanagerservice.api.request.UserRequest;
import com.eanimal.usermanagerservice.api.response.UserResponse;
import com.eanimal.usermanagerservice.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;

  @GetMapping("/user/{id}")
  public ResponseEntity<UserResponse> getUserById(@PathVariable final UUID id) {
    return ResponseEntity.ok(null);
  }

  @GetMapping("/users")
  public ResponseEntity<UserResponse> getAllUsers() {
    return ResponseEntity.ok(null);
  }

  @PostMapping("/email")
  public ResponseEntity<UserResponse> getUserByUserEmail(@RequestBody final String email) {
    return ResponseEntity.ok(null);
  }

  @PostMapping("/users")
  public ResponseEntity<UserResponse> createUser(@RequestBody final UserRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  @PatchMapping("/users/{id}")
  public ResponseEntity<UserResponse> updateUserById(@PathVariable final UUID id) {
    return ResponseEntity.ok(null);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<UserResponse> deleteUserById(@PathVariable final UUID id) {
    return ResponseEntity.ok(null);
  }
}
