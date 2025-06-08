package com.example.task.manager.dal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private Integer id;

    private String login;

    private String username;

    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<TaskEntity> tasks;

}
