package org.example.RESTonSpringBoot.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("parentTaskId")
    private Long parentTaskId;

    @JsonCreator
    public Task(Long id, String description, Long userId, Long parentTaskId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.parentTaskId = parentTaskId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Long parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", parentTaskId=" + parentTaskId +
                '}';
    }
}
