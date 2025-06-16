package com.example.task.manager.controller;

import com.example.task.manager.dto.CreateUserRequest;
import com.example.task.manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService service;

    @PostMapping
    public Integer create(@RequestBody CreateUserRequest request) {
        return service.create(request);
    }

}
