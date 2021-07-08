package org.example.RESTonSpringBoot.Services;

import org.example.RESTonSpringBoot.Entity.Task;
import org.example.RESTonSpringBoot.Mappers.TaskMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    JdbcTemplate jdbcTemplate;

    public TaskService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Task getTaskById(Long taskId) {
        String SQL = "SELECT * FROM tasks WHERE task_id = " + taskId.toString();
        List<Task> tasks = jdbcTemplate.query(SQL, new TaskMapper());
        return tasks.get(0);
    }

    public boolean createTask(Task task) {
        String SQL = "INSERT INTO tasks VALUES ('" + task.getId() + "', '" +
                task.getDescription() + "', '" +
                task.getUserId().toString() + "', '" +
                task.getParentTaskId().toString() + "')";
        try {
            jdbcTemplate.execute(SQL);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateTask(Long taskId, Task task) {
        String SQL = "UPDATE tasks SET description='" + task.getDescription() +
                "', user_id='" + task.getUserId().toString() +
                "', parent_task_id='" + task.getParentTaskId().toString() +
                "' WHERE task_id='" + taskId.toString() + "'";
        try {
            jdbcTemplate.execute(SQL);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteTask(Long taskId) {
        String SQL = "DELETE FROM tasks WHERE task_id='" + taskId.toString() + "'";
        try {
            jdbcTemplate.execute(SQL);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}