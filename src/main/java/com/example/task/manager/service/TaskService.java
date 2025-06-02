package com.example.task.manager.service;

import com.example.task.manager.dal.entity.TaskEntity;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.exception.NoSuchTaskException;
import com.example.task.manager.mapper.TaskMapper;
import com.example.task.manager.repository.TaskJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper mapper;
    private final TaskJpaRepository jpaRepository;

    public void create(CreateUpdateTaskDto dto) {
        TaskEntity task = mapper.mapForCreate(dto);
        jpaRepository.save(task);
    }

    public List<TaskEntity> read() {
        return jpaRepository.findAll();
    }

    public TaskEntity read(Integer id) {
        return jpaRepository.findById(id).orElseThrow(
                () -> new NoSuchTaskException(String.format("Задачи с ID = %d не существует", id))
        );
    }

    public void update(Integer id, CreateUpdateTaskDto dto) {
        TaskEntity task = jpaRepository.findById(id).orElseThrow(
                () -> new NoSuchTaskException(String.format("Задачи с ID = %d не существует", id))
        );
        mapper.mapForUpdate(task, dto);
        jpaRepository.save(task);
    }

    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }

}
