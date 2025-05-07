package com.example.task.manager.controller;

import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bug")
@RequiredArgsConstructor
public class BugController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateUpdateTaskDto dto) {
        try {
            service.create(dto);
            return ResponseEntity.ok(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Task read(@PathVariable Integer id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody CreateUpdateTaskDto body
    ) {
        try {
            service.update(id, body);
            return ResponseEntity.ok(null);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
