package com.example.task.manager.configuration;

import com.example.task.manager.service.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

    @Bean(name = "bugService")
    @Scope("prototype")
    @Primary
    public TaskService bugService() {
        return new TaskService("bug");
    }

    @Bean(name = "featureService")
    public TaskService featureService() {
        return new TaskService("feature");
    }

}
