package com.github.tr1cks.tasker.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class TaskComment implements DomainObj {
    @NotNull @Size(min = 32, max = 32)
    private String id;
    @NotNull @Size(min = 32, max = 32)
    private String authorId;
    @NotNull @Size(min = 32, max = 32)
    private String taskId;
    @NotNull @Size(min = 10, max = 200)
    private String text;
    @NotNull
    private Date created;

    public TaskComment() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAuthorId() { return authorId; }
    public void setAuthorId(String authorId) { this.authorId = authorId; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }

    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }
}