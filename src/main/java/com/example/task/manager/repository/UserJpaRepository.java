package com.example.task.manager.repository;

import com.example.task.manager.dal.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select u from UserEntity u left join fetch u.tasks")
    List<UserEntity> findAll();

}
