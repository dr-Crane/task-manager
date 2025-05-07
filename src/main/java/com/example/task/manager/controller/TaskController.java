package com.example.task.manager.controller;

import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Deprecated
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping("/task")
    public void create(@RequestBody CreateUpdateTaskDto dto) {
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

    @PutMapping("/task/{id}")
    public void update(
            @PathVariable Integer id,
            @RequestBody CreateUpdateTaskDto body
    ) {
        service.update(id, body);
    }

    @DeleteMapping("/task/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
