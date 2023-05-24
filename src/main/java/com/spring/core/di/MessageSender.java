package com.spring.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

//    Field based dependency injection
    @Autowired
    @Qualifier("sMSService")
    private MessageService defaultMessageService;
    private MessageService messageService;

//    Constructor based dependency injection
    @Autowired
    public MessageSender(@Qualifier("sMSService") MessageService messageService) {
        this.messageService = messageService;
    }

//    Setter based dependency injection
    @Autowired
    public void setMessageService(@Qualifier("emailService") MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendMessage(String message) {
        this.messageService.sendMessage(message);
    }

    public void sendDefaultMessage(String message) { this.defaultMessageService.sendMessage(message);}
}
