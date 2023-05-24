package com.spring.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LooselyCoupledTraveller {
    private Vehicle vehicle;

    @Autowired
    public LooselyCoupledTraveller(@Qualifier("car") Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney() {
        this.vehicle.move();
    }
}
