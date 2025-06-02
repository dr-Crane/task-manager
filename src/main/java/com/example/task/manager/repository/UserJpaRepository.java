package com.example.task.manager.repository;

import com.example.task.manager.dal.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Integer> {

//    @EntityGraph(attributePaths = "tasks")
//    List<UserEntity> findAll();

//    @Query("select u from UserEntity u left join fetch u.tasks")
//    List<UserEntity> findAll();

}
