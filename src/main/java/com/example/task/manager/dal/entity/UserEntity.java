package com.example.task.manager.dal.entity;

import com.example.task.manager.dal.enumeration.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @SequenceGenerator(
            name = "user_id",
            sequenceName = "user_id",
            allocationSize = 1
    )
    private Integer id;

    private String login;

    private String password;

    private String username;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<TaskEntity> tasks;

}
