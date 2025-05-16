package com.example.task.manager.configuration;

import com.example.task.manager.mapper.TaskMapper;
import com.example.task.manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final TaskMapper mapper;

    @Bean(name = "bugService")
    @Primary
    public TaskService bugService() {
        return new TaskService(mapper);
    }


}
