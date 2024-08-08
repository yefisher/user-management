package com.eanimal.usermanagerservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserPasswordEncoderTest {

  private static final String SECRET = "suppas3cr3t";
  private static final String PASSWORD = "dummy_password123";

  @Mock PasswordEncoder mockedEncoder;
  UserPasswordEncoder testable;

  @BeforeEach
  void setUp() {
    testable = new UserPasswordEncoder(SECRET, mockedEncoder);
  }

  @Test
  public void shouldEncodePasswordSuccessfully() {
    testable.encode(PASSWORD);
    ArgumentCaptor<CharSequence> captor = ArgumentCaptor.forClass(CharSequence.class);
    verify(mockedEncoder).encode(captor.capture());
    assertEquals(SECRET + PASSWORD + SECRET, captor.getValue().toString());
  }

  @Test
  public void shouldMatchPasswordsSuccessfully() {
    testable.matches(PASSWORD, "123");
    ArgumentCaptor<CharSequence> captor = ArgumentCaptor.forClass(CharSequence.class);
    verify(mockedEncoder).matches(captor.capture(), eq("123"));
    assertEquals(SECRET + PASSWORD + SECRET, captor.getValue().toString());
  }
}
