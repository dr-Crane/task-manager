package com.example.task.manager.controller;

import com.example.task.manager.dal.entity.UserEntity;
import com.example.task.manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserEntity> read() {
        return service.read();
    }

}
