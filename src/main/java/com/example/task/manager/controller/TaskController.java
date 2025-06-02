package com.example.task.manager.controller;

import com.example.task.manager.dal.entity.TaskEntity;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public void create(
            @Valid
            @RequestBody
            CreateUpdateTaskDto dto
    ) {
        service.create(dto);
    }

    @GetMapping
    public List<TaskEntity> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public TaskEntity read(@PathVariable Integer id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable
            Integer id,
            @Valid
            @RequestBody
            CreateUpdateTaskDto body
    ) {
        service.update(id, body);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
