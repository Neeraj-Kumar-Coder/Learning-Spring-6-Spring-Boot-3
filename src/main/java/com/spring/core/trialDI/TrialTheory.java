package com.spring.core.trialDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.spring.core.trialDI")
class LegendConfig {

}

@Component
class A {
    public A() {
        System.out.println("I am A constructor!");
    }
}

@Component
class B {
    A a;

    public B() {
        System.out.println("I am B constructor!");
    }

    @Autowired
    public void setA(@Qualifier("a") A a) {
        System.out.println("I am setA of B!");
        this.a = a;
    }
}

@Component
class C {
    A a;

    public C() {
        System.out.println("I am C constructor!");
    }

    @Autowired
    public void setA(@Qualifier("a") A a) {
        System.out.println("I am setA of C!");
        this.a = a;
    }
}
public class TrialTheory {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LegendConfig.class);
        B b = applicationContext.getBean(B.class);
        C c = applicationContext.getBean(C.class);
    }
}
