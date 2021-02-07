package com.cropchemistry.taskmanager.spring.config;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JerseyConfig extends ResourceConfig {
    @PostConstruct
    public void init() {
        packages("com.cropchemistry.taskmanager");
    }
}
