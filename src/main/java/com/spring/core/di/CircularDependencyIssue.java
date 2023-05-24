package com.spring.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * The constructor based dependency injection cause circular dependency in this code
 * To avoid this, we use setter based dependency injection
 * In setter based DI, the objects of both the classes are first made and then dependencies are resolved
 * But in case of constructor based DI, objection creation and dependency injection happens simultaneously and hence hindering the creation of the object
 * This is one of the important use case of setter based DI
 **/

@Configuration
@ComponentScan("com.spring.core.di")
class CoolAppConfig {

}

@Component
class DependencyA {
    DependencyB dependencyB;

//    public DependencyA(DependencyB dependencyB) {
//        this.dependencyB = dependencyB;
//    }


    @Autowired
    public void setDependencyB(@Qualifier("dependencyB") DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }

    public void say() {
        this.dependencyB.who();
    }

    public void who() {
        System.out.println("I am Dependency A");
    }
}

@Component
class DependencyB {
    DependencyA dependencyA;

//    public DependencyB(DependencyA dependencyA) {
//        this.dependencyA = dependencyA;
//    }


    @Autowired
    public void setDependencyA(@Qualifier("dependencyA") DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }

    public void say() {
        this.dependencyA.who();
    }

    public void who() {
        System.out.println("I am dependency B");
    }
}

public class CircularDependencyIssue {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CoolAppConfig.class);

        DependencyA dependencyA = applicationContext.getBean(DependencyA.class);
        DependencyB dependencyB = applicationContext.getBean(DependencyB.class);

        dependencyA.say();
        dependencyB.say();
    }
}
