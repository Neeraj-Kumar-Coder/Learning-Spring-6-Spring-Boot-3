package com.spring.core.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        String message = "Hi, how are you?";
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        messageSender.sendMessage(message);
        messageSender.sendDefaultMessage(message);
    }
}
