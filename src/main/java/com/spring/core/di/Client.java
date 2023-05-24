package com.spring.core.di;

public class Client {
    public static void main(String[] args) {
        MessageService messageService = new SMSService();
        MessageSender messageSender = new MessageSender(messageService);
        String message = "Hi, how are you?";

        messageSender.sendMessage(message);
    }
}
