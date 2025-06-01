package com.example.task.manager.dto;

import com.example.task.manager.dal.enumeration.Priority;
import com.example.task.manager.dal.enumeration.Status;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUpdateTaskDto {

    @Size(max = 40, message = "Длина не больше 30")
    @Pattern(regexp = "^[а-яА-ЯёЁ ]*$")
    private String title;

    @Size(max = 200, message = "Длина не больше 200")
    private String description;

    private Priority priority;

    private Status status;

}
