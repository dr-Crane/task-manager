package com.example.task.manager.dto;

import com.example.task.manager.dal.entity.UserEntity;
import com.example.task.manager.dal.enumeration.Priority;
import com.example.task.manager.dal.enumeration.Status;
import lombok.Data;

@Data
public class TaskDto {

    private Integer id;

    private String title;

    private String description;

    private Priority priority;

    private Status status;

    private UserEntity user;

}
