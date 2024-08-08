package com.eanimal.usermanagerservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserPasswordEncoder implements PasswordEncoder {

  private final CharSequence secrete;
  private final PasswordEncoder encoder;

  public UserPasswordEncoder(CharSequence secrete, PasswordEncoder encoder) {
    if (secrete == null || secrete.isEmpty())
      throw new RuntimeException("PasswordEncoder secrete is not set");
    this.secrete = secrete;
    this.encoder = encoder;
  }

  @Override
  public String encode(CharSequence rawPassword) {
    return encoder.encode(disguise(rawPassword));
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return encoder.matches(disguise(rawPassword), encodedPassword);
  }

  private CharSequence disguise(final CharSequence rawPassword) {
    return new StringBuilder(secrete).append(rawPassword).append(secrete);
  }
}
