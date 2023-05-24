package com.spring.core.configurations;

import com.spring.core.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedAppConfig {

    @Bean
    public Vehicle car() {
        return new Car();
    }

    @Bean
    public Vehicle bike() {
        return new Bike();
    }

    @Bean
    public Vehicle cycle() {
        return new Cycle();
    }

    @Bean
    public LooselyCoupledTraveller looselyCoupledTraveller() {
        return new LooselyCoupledTraveller(cycle()); // DI (Dependency Injection)
    }
}
