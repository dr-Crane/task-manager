package com.example.task.manager.repository;

import com.example.task.manager.dal.Priority;
import com.example.task.manager.dal.Status;
import com.example.task.manager.dal.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskJdbcRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Task> get() {
        return jdbcTemplate.query(
                "SELECT * FROM tasks;",
                (rs, rowNum) -> {
                    var task = new Task()
                            .setId(rs.getInt("id"))
                            .setTitle(rs.getString("title"))
                            .setDescription(rs.getString("description"))
                            .setPriority(Priority.valueOf(rs.getString("priority")))
                            .setStatus(Status.valueOf(rs.getString("status")))
                            .setCreatedAt(rs.getTimestamp("created_at").toInstant());
                    Timestamp timestamp = rs.getTimestamp("updated_at");
                    if (timestamp != null) {
                        task.setUpdatedAt(timestamp.toInstant());
                    }
                    return task;
                }
        );
    }

    public Task getById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", id);
        return jdbcTemplate.query(
                "SELECT * FROM tasks WHERE id = :id;",
                parameterSource,
                (rs, rowNum) -> new Task()
                        .setId(rs.getInt("id"))
                        .setTitle(rs.getString("title"))
                        .setDescription(rs.getString("description"))
        ).getFirst();
    }

}
