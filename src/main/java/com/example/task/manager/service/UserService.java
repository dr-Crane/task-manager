package com.example.task.manager.service;

import com.example.task.manager.dal.entity.UserEntity;
import com.example.task.manager.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository jpaRepository;

    public List<UserEntity> read() {
        return jpaRepository.findAll();
    }

}
