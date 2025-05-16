package com.example.task.manager.controller;

import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bug")
@RequiredArgsConstructor
public class BugController {

    private final TaskService service;

    @PostMapping
    public void create(@RequestBody CreateUpdateTaskDto dto) {
        service.create(dto);
    }

    @GetMapping("/{id}")
    public Task read(@PathVariable Integer id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Integer id,
            @RequestBody CreateUpdateTaskDto body
    ) {
        service.update(id, body);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
