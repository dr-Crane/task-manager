package com.example.task.manager.controller;

import com.example.task.manager.dal.enumeration.Role;
import com.example.task.manager.dto.UserDto;
import com.example.task.manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public List<UserDto> read() {
        return service.read();
    }

    // или @PreAuthorize("#userId == authentication.principal.username")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateRole(@PathVariable Integer id, @RequestParam Role role) {
        service.update(id, role);
    }

}
