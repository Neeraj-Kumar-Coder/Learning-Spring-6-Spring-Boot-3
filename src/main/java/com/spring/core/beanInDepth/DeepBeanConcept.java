package com.spring.core.beanInDepth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SuperAppConfig {
//    Explicitly assigned bean name
    @Bean(name = "addressBean")
    public Address address() {
        return new Address();
    }

//    A single bean can have multiple names
    @Bean(name = {"studentBean", "studentMrBean"}, initMethod = "studentInitialization", destroyMethod = "studentDestruction")
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

    public void studentInitialization() {
        System.out.println("Student initialization is done...");
    }

    public void studentDestruction() {
        System.out.println("Student desctruction is done...");
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

//        Used to get all the names of the beans (user specified, default names)
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName: beanNames) {
            System.out.println(beanName);
        }

//        Method to close the applicationContext [as found on stackoverflow: https://stackoverflow.com/questions/14423980/how-to-close-a-spring-applicationcontext]
        ((ConfigurableApplicationContext)applicationContext).close();
    }
}
