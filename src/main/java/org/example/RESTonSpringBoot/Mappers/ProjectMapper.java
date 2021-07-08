package org.example.RESTonSpringBoot.Mappers;

import org.example.RESTonSpringBoot.Entity.Project;
import org.example.RESTonSpringBoot.Entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project(
                rs.getLong("project_id"),
                rs.getString("description")
        );
        return project;
    }
}