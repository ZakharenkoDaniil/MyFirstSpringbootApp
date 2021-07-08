package org.example.RESTonSpringBoot.Services;


import org.example.RESTonSpringBoot.Entity.User;
import org.example.RESTonSpringBoot.Mappers.UserMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    JdbcTemplate jdbcTemplate;
    public UserService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public User getUserById(Long userId){
        String SQL = "SELECT * FROM users WHERE user_id = "+userId.toString();
        List<User> users = jdbcTemplate.query(SQL, new UserMapper());
        return users.get(0);
    }

    public boolean createUser(User user){
        String SQL = "INSERT INTO users VALUES ('"+user.getId()+
                "', '"+user.getName()+
                "', '"+ user.getProjectId().toString()+ "')";
        try {
            jdbcTemplate.execute(SQL);
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateUser(Long userId, User user){
        String SQL = "UPDATE users SET name='"+user.getName()+
                "', project_id='"+ user.getProjectId().toString()+
                "' WHERE user_id='"+userId.toString()+"'";
        try{
            jdbcTemplate.execute(SQL);
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteUser(Long userId){
        String SQL = "DELETE FROM users WHERE user_id='"+userId.toString()+"'";
        try{
            jdbcTemplate.execute(SQL);
        }catch(DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
