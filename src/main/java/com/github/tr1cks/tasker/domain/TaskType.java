package com.github.tr1cks.tasker.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskType implements DomainObj {
    @NotNull @Size(min = 32, max = 32)
    private String id;
    @NotNull @Size(min = 3, max = 30)
    private String name;

    public TaskType() {}

    public TaskType(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}