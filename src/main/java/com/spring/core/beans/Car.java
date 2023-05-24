package com.spring.core.beans;

import org.springframework.stereotype.Component;

@Component("car")
public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Car is moving...");
    }
}
