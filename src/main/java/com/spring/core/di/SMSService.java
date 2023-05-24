package com.spring.core.di;

import org.springframework.stereotype.Component;

@Component("sMSService")
public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println(String.format("Message sent via SMS Service: %s", message));
    }
}
