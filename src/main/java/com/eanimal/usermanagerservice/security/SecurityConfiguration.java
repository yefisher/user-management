package com.eanimal.usermanagerservice.security;

import com.eanimal.usermanagerservice.service.UserPasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {

  @Value("${eanimal.pwd.strength:12}")
  private int strength;

  @Value("${eanimal.pwd.secret:abcd}")
  private CharSequence secret;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new UserPasswordEncoder(secret, new BCryptPasswordEncoder(strength));
  }
}
