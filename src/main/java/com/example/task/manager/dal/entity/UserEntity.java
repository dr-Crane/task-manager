package com.example.task.manager.dal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @OneToMany
    @JoinColumn(name = "responsible")
//    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
    private List<TaskEntity> tasks;

}
