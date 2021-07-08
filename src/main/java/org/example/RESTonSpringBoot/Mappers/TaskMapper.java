package org.example.RESTonSpringBoot.Mappers;

import org.example.RESTonSpringBoot.Entity.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task(
                rs.getLong("task_id"),
                rs.getString("description"),
                rs.getLong("user_id"),
                rs.getLong("parent_task_id"));
        return task;
    }
}
