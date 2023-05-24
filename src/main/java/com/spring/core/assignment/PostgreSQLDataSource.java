package com.spring.core.assignment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSQLDataSource implements DataSource {
    String[] emails;

    public PostgreSQLDataSource() {
        this.emails = new String[]{"example@gmail.com", "logan@gmail.com", "alphazero@gmail.com", "coolboy@gmail.com"};
    }

    @Override
    public String[] getEmails() {
        return emails;
    }
}
