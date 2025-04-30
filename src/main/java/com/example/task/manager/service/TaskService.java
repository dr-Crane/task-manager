package com.example.task.manager.service;

import com.example.task.manager.dal.Status;
import com.example.task.manager.dal.Task;
import com.example.task.manager.dto.TaskDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {

    private int sequence = 1;
    private final Map<Integer, Task> database = new HashMap<>();

    public void create(TaskDto dto) {
        Task task = new Task(
                sequence,
                dto.getTitle(),
                dto.getDescription(),
                dto.getPriority(),
                Status.NEW
        );
        sequence++;
        database.put(task.getId(), task);
    }

    public Task read(Integer id) {
        return database.get(id);
    }

    public List<Task> read() {
        return database.values().stream().toList();
    }

}
