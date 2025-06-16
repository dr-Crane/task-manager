package com.example.task.manager.service;

import com.example.task.manager.dal.enumeration.Role;
import com.example.task.manager.dal.entity.UserEntity;
import com.example.task.manager.dto.CreateUserRequest;
import com.example.task.manager.dto.UserDto;
import com.example.task.manager.exception.UserNotFoundException;
import com.example.task.manager.mapper.UserMapper;
import com.example.task.manager.repository.UserJpaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository jpaRepository;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;

    @Transactional(readOnly = true)
    public List<UserDto> read() {
        List<UserEntity> users = jpaRepository.findAll();
        return mapper.map(users);
    }

    @Transactional
    public Integer create(@Valid CreateUserRequest request) {
        UserEntity user = mapper.map(request);
        String passwordHash = encoder.encode(request.getPassword());
        user.setPassword(passwordHash);
        return jpaRepository.save(user).getId();
    }

    @Transactional
    public void update(Integer id, Role role) {
        UserEntity user = jpaRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setRole(role);
        jpaRepository.save(user);
    }

}
