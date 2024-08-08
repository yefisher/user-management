package com.eanimal.usermanagerservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
class UserManagementApplicationTests {

  private static final PostgresExtension postgres = new PostgresExtension();

  @Test
  void contextLoads() throws Exception {
    postgres.executeSQL("resources/fixture/user-data-insert-fixture.sql");
  }
}
