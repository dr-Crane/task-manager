package com.example.task.manager.dal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Task {

    private Integer id;

    private String title;

    private String description;

    private Priority priority;

    private Status status;

    private Instant createdAt;

    private Instant updatedAt;

}
