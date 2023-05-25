package com.spring.core.assignment.usingJavaBasedConfiguration;

public class EmailService {
    private DataSource dataSource;

    public EmailService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void sendEmail() {
        String[] emails = dataSource.getEmails();
        for (String email: emails) {
            System.out.println(String.format("Email sent to: %s", email));
        }
    }
}
