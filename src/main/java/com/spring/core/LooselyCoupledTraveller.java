package com.spring.core;

public class LooselyCoupledTraveller {
    private Vehicle vehicle;
    public LooselyCoupledTraveller(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startJourney() {
        this.vehicle.move();
    }
}
