package com.example.task.manager.dal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Integer id;

    private String title;

    private String description;

    private Priority priority;

    private Status status;

    private final Instant createdAt = Instant.now();

    private Instant updatedAt;

}
