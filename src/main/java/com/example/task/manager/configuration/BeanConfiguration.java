package com.example.task.manager.configuration;

import com.example.task.manager.service.TaskService;


public class BeanConfiguration {

    public TaskService taskService() {
        return new TaskService();
    }

}
