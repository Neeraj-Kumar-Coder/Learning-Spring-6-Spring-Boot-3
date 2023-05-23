package com.spring.core;

public class Client {
    public static void main(String[] args) {
//        TightlyCoupledTraveller tightlyCoupledTraveller = new TightlyCoupledTraveller();
//        tightlyCoupledTraveller.startJourney();

        Vehicle vehicle = new Cycle();
        LooselyCoupledTraveller looselyCoupledTraveller = new LooselyCoupledTraveller(vehicle);
        looselyCoupledTraveller.startJourney();
    }
}
