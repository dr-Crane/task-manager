package com.example.task.manager.controller;

import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.TaskDto;
import com.example.task.manager.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping("/task")
    public void create(@RequestBody TaskDto dto) {
        service.create(dto);
    }

    @GetMapping("/task")
    public Task read(@RequestParam Integer id) {
        return service.read(id);
    }

    @GetMapping("/tasks")
    public List<Task> read() {
        return service.read();
    }


}
