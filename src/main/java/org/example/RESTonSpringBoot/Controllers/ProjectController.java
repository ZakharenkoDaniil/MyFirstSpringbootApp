package org.example.RESTonSpringBoot.Controllers;

import org.example.RESTonSpringBoot.Entity.Project;
import org.example.RESTonSpringBoot.Services.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/project/{projectId}")
    public String getProject(@PathVariable("projectId") Long projectId) {
        return projectService.getProjectById(projectId).toString();
    }

    @PostMapping("/project")
    public String postProject(@RequestBody Project project){
        boolean result = projectService.createProject(project);
        if(result){
            return "successfully post "+project.toString();
        }
        return "posting error";
    }

    @PutMapping("/project/{projectId}")
    public String putProject(@PathVariable("projectId") Long projectId, @RequestBody Project project){
        boolean result = projectService.updateProject(projectId, project);
        if(result){
            return "successfully put";
        }
        return "puting error";
    }

    @DeleteMapping("/project/{projectId}")
    public String deleteProject(@PathVariable("projectId") Long projectId){
        boolean result = projectService.deleteProject(projectId);
        if(result){
            return "successfully delete";
        }
        return "deleting error";
    }

}
