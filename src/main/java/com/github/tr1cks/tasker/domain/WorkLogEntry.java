package com.github.tr1cks.tasker.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class WorkLogEntry implements DomainObj {
    @NotNull @Size(min = 32, max = 32)
    private String id;
    @NotNull @Size(min = 32, max = 32)
    private String taskId;
    @NotNull @Size(min = 32, max = 32)
    private String authorId;
    @NotNull
    private Date created;
    @NotNull @Min(1) @Max(8)
    private Integer hours;
    @NotNull @Size(min = 10, max = 200)
    private String text;

    public WorkLogEntry() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }

    public Integer getHours() { return hours; }
    public void setHours(Integer hours) { this.hours = hours; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }

    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }
}