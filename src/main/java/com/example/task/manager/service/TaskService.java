package com.example.task.manager.service;

import com.example.task.manager.dal.Feature;
import com.example.task.manager.dal.Status;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateFeatureDto;
import com.example.task.manager.dto.CreateUpdateTaskDto;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    private int sequence = 1;
    private final Map<Integer, Task> database = new HashMap<>();

    public void create(CreateUpdateTaskDto dto) {
        validate(dto);
        Task task = map(new Task(), dto);
        database.put(task.getId(), task);
    }

    public Integer create(CreateUpdateFeatureDto dto) {
        validate(dto);
        Feature feature = map(new Feature(), dto);
        dto.getSubtasks().forEach(task -> {
            Task subtask = map(new Task(), task);
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
        validate(dto);
        Task task = database.get(id);
        task.setUpdatedAt(Instant.now());
        Task result = map(task, dto);
        database.put(id, result);
    }

    public void delete(Integer id) {
        Task task = database.remove(id);
        if (task instanceof Feature feature) {
            feature.getSubtasks().forEach(subtask -> database.remove(subtask.getId()));
        }
    }

    private <T extends Task> T map(T task, CreateUpdateTaskDto dto) {
        if (task.getId() == null) {
            task.setId(sequence);
            sequence++;
        }
        if (dto.getTitle() != null) {
            task.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null) {
            task.setDescription(dto.getDescription());
        }
        if (dto.getPriority() != null) {
            task.setPriority(dto.getPriority());
        }
        if (dto.getStatus() == null) {
            task.setStatus(Status.NEW);
        } else {
            task.setStatus(dto.getStatus());
        }
        return task;
    }

    private void validate(CreateUpdateTaskDto dto) {
        if (dto.getTitle().length() >= 30) {
            throw new RuntimeException("Длина заголовка больше 30 символов");
        }
        if (dto.getDescription().length() >= 200) {
            throw new RuntimeException("Длина описания больше 200 символов");
        }
    }

}
