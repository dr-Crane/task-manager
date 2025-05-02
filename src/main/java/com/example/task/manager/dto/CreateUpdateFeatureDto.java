package com.example.task.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateUpdateFeatureDto extends CreateUpdateTaskDto {

    private List<CreateUpdateTaskDto> subtasks;

}
