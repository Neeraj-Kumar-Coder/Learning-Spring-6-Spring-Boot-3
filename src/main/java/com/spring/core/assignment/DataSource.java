package com.spring.core.assignment;

import org.springframework.stereotype.Component;

@Component
public interface DataSource {
    String[] getEmails();
}
