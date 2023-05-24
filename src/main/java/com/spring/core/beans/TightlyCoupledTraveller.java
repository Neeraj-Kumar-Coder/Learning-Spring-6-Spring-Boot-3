package com.spring.core.beans;

public class TightlyCoupledTraveller {
    Car car = null;

    public TightlyCoupledTraveller() {
        this.car = new Car();
    }

    public void startJourney() {
        this.car.move();
    }
}
