package com.spring.core.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {
    public String say() {
        return "Hello from repository!";
    }
}
