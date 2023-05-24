package com.spring.core.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("cycle")
public class Cycle implements Vehicle {
    @Override
    public void move() {
        System.out.println("Cycle is moving...");
    }
}
