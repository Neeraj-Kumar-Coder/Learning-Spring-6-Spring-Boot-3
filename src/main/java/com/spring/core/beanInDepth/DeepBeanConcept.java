package com.spring.core.beanInDepth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SuperAppConfig {
//    Explicitly assigned bean name
    @Bean("addressBean")
    public Address address() {
        return new Address();
    }

//    A single bean can have multiple names
    @Bean({"studentBean", "studentMrBean"})
    public Student student() {
        return new Student(address());
    }
}

class Student {
    private Address address;

    public Student(Address address) {
        this.address = address;
    }

    public void print() {
        System.out.println("Student class print() method called!");
    }
}

class Address {
    public void print() {
        System.out.println("Address class print() method called!");
    }
}

public class DeepBeanConcept {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SuperAppConfig.class);

//        Method 1 of getting the bean
        Student student = applicationContext.getBean(Student.class);

//        Method 2 of getting the bean [NEEDS TYPECASTING]
        Address address = (Address) applicationContext.getBean("addressBean");

        Student mrBean = (Student) applicationContext.getBean("studentMrBean");

        student.print();
        address.print();
        mrBean.print();

        String []beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName: beanNames) {
            System.out.println(beanName);
        }
    }
}
