package com.spring.core.assignment.usingJavaBasedConfiguration;

public class MySQLDataSource implements DataSource {
    String[] emails;

    public MySQLDataSource() {
        this.emails = new String[]{"example@gmail.com", "logan@gmail.com", "alphazero@gmail.com"};
    }

    @Override
    public String[] getEmails() {
        return emails;
    }
}
