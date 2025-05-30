package com.example.task.manager.dto;

import com.example.task.manager.dal.Priority;
import com.example.task.manager.dal.Status;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CreateUpdateTaskDto {

    @Size(max = 40, message = "Длина не больше 30")
    private String title;

    @Size(max = 200, message = "Длина не больше 200")
    private String description;

    private Priority priority;

    private Status status;

}
