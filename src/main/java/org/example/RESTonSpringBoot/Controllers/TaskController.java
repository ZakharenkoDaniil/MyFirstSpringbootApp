package org.example.RESTonSpringBoot.Controllers;

import org.example.RESTonSpringBoot.Entity.Project;
import org.example.RESTonSpringBoot.Entity.Task;
import org.example.RESTonSpringBoot.Services.ProjectService;
import org.example.RESTonSpringBoot.Services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/task/{taskId}")
    public String getTask(@PathVariable("taskId") Long taskId) {
        return taskService.getTaskById(taskId).toString();
    }

    @PostMapping("/task")
    public String postTask(@RequestBody Task task){
        boolean result = taskService.createTask(task);
        if(result){
            return "successfully post "+task.toString();
        }
        return "posting error";
    }

    @PutMapping("/task/{taskId}")
    public String putTask(@PathVariable("taskId") Long taskId, @RequestBody Task task){
        boolean result = taskService.updateTask(taskId, task);
        if(result){
            return "successfully put";
        }
        return "puting error";
    }

    @DeleteMapping("/task/{taskId}")
    public String deleteUser(@PathVariable("taskId") Long taskId){
        boolean result = taskService.deleteTask(taskId);
        if(result){
            return "successfully delete";
        }
        return "deleting error";
    }

}
