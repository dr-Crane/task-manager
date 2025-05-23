package com.example.task.manager.service;

import com.example.task.manager.dal.Feature;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateFeatureDto;
import com.example.task.manager.dto.CreateUpdateTaskDto;
import com.example.task.manager.exception.InvalidTitleException;
import com.example.task.manager.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class TaskService {

    private int sequence = 1;
    private final Map<Integer, Task> database = new HashMap<>();
    private final TaskMapper mapper;

    public void create(CreateUpdateTaskDto dto) {
        String title = dto.getTitle();
        if(!title.matches("^[а-яА-ЯёЁ ]*$")){
            String message = "Не допустимое имя задачи!";
            log.error(message);
            throw new InvalidTitleException(message);
        }

        Task task = mapper.mapForCreate(sequence, dto);
        sequence++;
        database.put(task.getId(), task);
    }

    public Integer create(CreateUpdateFeatureDto dto) {
        Feature feature = mapper.mapForCreateFeature(sequence, dto);
        sequence++;
        dto.getSubtasks().forEach(task -> {
            Task subtask = mapper.mapForCreate(sequence, task);
            sequence++;
            database.put(subtask.getId(), subtask);
            feature.getSubtasks().add(subtask);
        });
        database.put(feature.getId(), feature);
        return feature.getId();
    }

    public Task read(Integer id) {
        return database.get(id);
    }

    public List<Task> read() {
        return database.values().stream().toList();
    }

    public void update(Integer id, CreateUpdateTaskDto dto) {
        Task task = database.get(id);
        task.setUpdatedAt(Instant.now());
        mapper.mapForUpdate(task, dto);
        database.put(id, task);
    }

    public void delete(Integer id) {
        Task task = database.remove(id);
        if (task instanceof Feature feature) {
            feature.getSubtasks().forEach(subtask -> database.remove(subtask.getId()));
        }
    }

}
