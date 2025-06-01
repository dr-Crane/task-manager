package com.example.task.manager.repository;

import com.example.task.manager.dal.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskEntity, Integer> {

    @Modifying
    @Query(value = "delete from TaskEntity e where e.id = :id")
    void deleteById(@Param("id") Integer id);

}
