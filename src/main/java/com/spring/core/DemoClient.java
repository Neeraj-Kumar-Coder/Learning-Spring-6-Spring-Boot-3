package com.spring.core;

import com.spring.core.configurations.AnnotationBasedAppConfig;
import com.spring.core.controller.DemoController;
import com.spring.core.repository.DemoRepository;
import com.spring.core.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationBasedAppConfig.class);

        DemoController demoController = applicationContext.getBean(DemoController.class);
        System.out.println(demoController.say());

        DemoRepository demoRepository = applicationContext.getBean(DemoRepository.class);
        System.out.println(demoRepository.say());

        DemoService demoService = applicationContext.getBean(DemoService.class);
        System.out.println(demoService.say());
    }
}
