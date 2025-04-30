package com.example.task.manager.dto;

import com.example.task.manager.dal.Priority;
import com.example.task.manager.dal.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUpdateTaskDto {

    private String title;

    private String description;

    private Priority priority;

    private Status status;

}
