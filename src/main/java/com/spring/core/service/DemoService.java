package com.spring.core.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String say() {
        return "Hello from service!";
    }
}
