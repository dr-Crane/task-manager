package com.example.task.manager.controller;

import com.example.task.manager.dal.Feature;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateFeatureDto;
import com.example.task.manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feature")
@RequiredArgsConstructor
public class FeatureController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody CreateUpdateFeatureDto dto) {
        try {
            return ResponseEntity.ok(service.create(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Feature read(@PathVariable Integer id) {
        return (Feature) service.read(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    //TODO: реализовать PUT для Feature
    //TODO: реализовать контроллер для Bug

    @GetMapping("/with-filters")
    public List<Task> getFirst(@RequestParam Integer limit) {
        return service.read().stream().limit(limit).toList();
    }

}
