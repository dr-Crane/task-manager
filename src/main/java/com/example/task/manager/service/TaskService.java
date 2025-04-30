package com.example.task.manager.service;

import com.example.task.manager.dal.Status;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.CreateUpdateTaskDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    private int sequence = 1;
    private final Map<Integer, Task> database = new HashMap<>();

    public void create(CreateUpdateTaskDto dto) {
        Task task = map(new Task(), dto);
        database.put(task.getId(), task);
    }

    public Task read(Integer id) {
        return database.get(id);
    }

    public List<Task> read() {
        return database.values().stream().toList();
    }

    public void update(Integer id, CreateUpdateTaskDto dto) {
        Task task = database.get(id);
        Task result = map(task, dto);
        database.put(id, result);
    }

    public void delete(Integer id) {
        database.remove(id);
    }

    private Task map(Task task, CreateUpdateTaskDto dto) {
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

}
