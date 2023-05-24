package com.spring.core.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.spring.core.beans",
        "com.spring.core.controller",
        "com.spring.core.repository",
        "com.spring.core.service"})
public class AnnotationBasedAppConfig {

}
