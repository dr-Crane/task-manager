package com.example.task.manager.controller;

import com.example.task.manager.dal.Task;
import com.example.task.manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feature")
@RequiredArgsConstructor
public class FeatureController {

    private final TaskService service;

    @GetMapping
    public List<Task> getFirst(@RequestParam Integer limit) {
        return service.read().stream().limit(limit).toList();
    }

}
