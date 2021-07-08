package org.example.RESTonSpringBoot.Services;

import org.example.RESTonSpringBoot.Entity.Project;
import org.example.RESTonSpringBoot.Mappers.ProjectMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    JdbcTemplate jdbcTemplate;
    public ProjectService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Project getProjectById(Long projectId){
        String SQL = "SELECT * FROM projects WHERE project_id = "+projectId.toString();
        List<Project> projects = jdbcTemplate.query(SQL, new ProjectMapper());
        return projects.get(0);
    }

    public boolean createProject(Project project){
        String SQL = "INSERT INTO projects VALUES ('" + project.getId() +
                "', '"+project.getDescription()+ "')";
        try {
            jdbcTemplate.execute(SQL);
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateProject(Long projectId, Project project){
        String SQL = "UPDATE projects SET description='"+project.getDescription()+
                "' WHERE project_id='"+projectId.toString()+"'";
        try{
            jdbcTemplate.execute(SQL);
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteProject(Long projectId){
        String SQL = "DELETE FROM projects WHERE project_id='"+projectId.toString()+"'";
        try{
            jdbcTemplate.execute(SQL);
        }catch(DataAccessException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
