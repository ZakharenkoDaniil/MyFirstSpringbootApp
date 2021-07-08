package org.example.RESTonSpringBoot.Mappers;

import org.example.RESTonSpringBoot.Entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getLong("user_id"),
                rs.getString("name"),
                rs.getLong("project_id"));
        return user;
    }
}
