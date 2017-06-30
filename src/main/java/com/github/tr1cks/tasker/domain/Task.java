package com.github.tr1cks.tasker.domain;

import javax.validation.constraints.*;

public class Task implements DomainObj {
    @NotNull @Size(min = 32, max = 32)
    private String id;

    @NotNull @Size(min = 3, max = 30)
    private String name;
    @NotNull @Size(min = 10, max = 200)
    private String description;
    @NotNull @Size(min = 32, max = 32)
    private String projectId;
    @NotNull @Size(min = 32, max = 32)
    private String typeId;
    @NotNull @Size(min = 32, max = 32)
    private String priorityId;
    @NotNull @Size(min = 32, max = 32)
    private String assigneeId;
    @NotNull @Min(1) @Max(80)
    private Integer estimatedTimeInHours;
    @NotNull
    private Boolean closed;

    public Task() {}

    public Task(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTypeId() { return typeId; }
    public void setTypeId(String typeId) { this.typeId = typeId; }

    public String getPriorityId() { return priorityId; }
    public void setPriorityId(String priorityId) { this.priorityId = priorityId; }

    public String getAssigneeId() { return assigneeId; }
    public void setAssigneeId(String assigneeId) { this.assigneeId = assigneeId; }

    public Integer getEstimatedTimeInHours() { return estimatedTimeInHours; }
    public void setEstimatedTimeInHours(Integer estimatedTimeInHours) { this.estimatedTimeInHours = estimatedTimeInHours; }

    public Boolean getClosed() { return closed; }
    public void setClosed(Boolean closed) { this.closed = closed; }
}