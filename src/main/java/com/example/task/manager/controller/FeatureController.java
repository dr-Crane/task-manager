package com.example.task.manager.controller;

import com.example.task.manager.dal.Feature;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateFeatureDto;
import com.example.task.manager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feature")
@RequiredArgsConstructor
@Validated
public class FeatureController {

    private final TaskService service;

    @PostMapping
    public Integer create(
            @Valid
            @RequestBody CreateUpdateFeatureDto dto
    ) {
        return service.create(dto);
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

    @GetMapping("/with-filters")
    public List<Task> getFirst(@RequestParam Integer limit) {
        return service.read().stream().limit(limit).toList();
    }

}
