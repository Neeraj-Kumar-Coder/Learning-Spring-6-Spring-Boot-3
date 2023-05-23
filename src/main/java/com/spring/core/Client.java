package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
//        TightlyCoupledTraveller tightlyCoupledTraveller = new TightlyCoupledTraveller();
//        tightlyCoupledTraveller.startJourney();

//        Vehicle vehicle = new Cycle();
//        LooselyCoupledTraveller looselyCoupledTraveller = new LooselyCoupledTraveller(vehicle);
//        looselyCoupledTraveller.startJourney();

//        Creating the spring IoC container
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = applicationContext.getBean(Car.class);
        car.move();

        Cycle cycle = applicationContext.getBean(Cycle.class);
        cycle.move();

        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();

        LooselyCoupledTraveller looselyCoupledTraveller = applicationContext.getBean(LooselyCoupledTraveller.class);
        looselyCoupledTraveller.startJourney();
    }
}
