package com.spring.core;

public class TightlyCoupledTraveller {
    Car car = null;

    public TightlyCoupledTraveller() {
        this.car = new Car();
    }

    public void startJourney() {
        this.car.move();
    }
}
