package com.springboot.firstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFirstAppApplication {

	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootFirstAppApplication.class, args);
		HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
		System.out.println(helloWorld.say());

		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName: beanNames) {
			System.out.println(beanName);
		}
	}
}
