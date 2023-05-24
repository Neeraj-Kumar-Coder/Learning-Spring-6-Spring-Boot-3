package com.spring.core;

import com.spring.core.beans.Bike;
import com.spring.core.beans.Car;
import com.spring.core.beans.Cycle;
import com.spring.core.beans.LooselyCoupledTraveller;
import com.spring.core.configurations.AnnotationBasedAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
//        TightlyCoupledTraveller tightlyCoupledTraveller = new TightlyCoupledTraveller();
//        tightlyCoupledTraveller.startJourney();

//        Vehicle vehicle = new Cycle();
//        LooselyCoupledTraveller looselyCoupledTraveller = new LooselyCoupledTraveller(vehicle);
//        looselyCoupledTraveller.startJourney();

//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaBasedAppConfig.class);
//
//        Car car = applicationContext.getBean(Car.class);
//        car.move();
//
//        Cycle cycle = applicationContext.getBean(Cycle.class);
//        cycle.move();
//
//        Bike bike = applicationContext.getBean(Bike.class);
//        bike.move();
//
//        LooselyCoupledTraveller looselyCoupledTraveller = applicationContext.getBean(LooselyCoupledTraveller.class);
//        looselyCoupledTraveller.startJourney();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationBasedAppConfig.class);

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
