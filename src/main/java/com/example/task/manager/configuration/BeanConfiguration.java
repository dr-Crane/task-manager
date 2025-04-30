package com.example.task.manager.configuration;

import com.example.task.manager.service.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TaskService taskService() {
        return new TaskService();
    }

}
