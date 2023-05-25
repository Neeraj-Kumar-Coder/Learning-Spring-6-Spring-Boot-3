package com.spring.core.assignment.usingJavaBasedConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MySQLDataSource mySQLDataSource() {
        return new MySQLDataSource();
    }

    @Bean
    public PostgreSQLDataSource postgreSQLDataSource() {
        return new PostgreSQLDataSource();
    }

    @Bean
    public EmailService emailService() {
        return new EmailService(postgreSQLDataSource());
    }
}
