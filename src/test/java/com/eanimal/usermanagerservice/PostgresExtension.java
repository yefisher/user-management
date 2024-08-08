package com.eanimal.usermanagerservice;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

@Log4j2
@NoArgsConstructor
public class PostgresExtension implements BeforeAllCallback, AfterAllCallback {

    private final static String POSTGRES_VERSION = "16-3.4-alpine";
    private final static String DB_NAME = "user-management-db";
    private final static Integer PORT = 5432;

    private final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");


    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        if (postgres.isRunning()) postgres.stop();
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        if (!postgres.isRunning()) postgres.start();
    }

    public String getUri() {
        return "jdbc:postgres://" + postgres.getHost() + ":" + postgres.getMappedPort(PORT) + "/" + DB_NAME;
    }

    Connection getConnection() {
        try {
            return DriverManager.getConnection(getUri());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDb() throws SQLException {
        return getConnection().getCatalog();
    }

   public void executeSQL(final String dataFile) throws SQLException {
        try (Scanner scm = new Scanner(this.getClass().getResourceAsStream(dataFile))) {
            Statement statement = getConnection().createStatement();
            String line;
            while ((line = scm.next()) != null) {
                statement.execute(line);
            }
        }
   }
}
