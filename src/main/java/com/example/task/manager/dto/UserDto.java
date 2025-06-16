package com.example.task.manager.dto;

import com.example.task.manager.dal.enumeration.Role;
import com.example.task.manager.dal.entity.TaskEntity;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Integer id;

    private String login;

    private String username;

    private Role role;

    private String email;

    private List<TaskEntity> tasks;

}
