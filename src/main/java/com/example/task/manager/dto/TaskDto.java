package com.example.task.manager.dto;

import com.example.task.manager.dal.Priority;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDto {

    private String title;

    private String description;

    private Priority priority;

}
