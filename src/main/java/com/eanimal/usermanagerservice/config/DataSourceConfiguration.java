package com.eanimal.usermanagerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.eanimal.usermanagerservice.repository")
public class DataSourceConfiguration {
}
