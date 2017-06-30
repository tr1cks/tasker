package com.github.tr1cks.tasker.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskPriority implements DomainObj {
    @NotNull @Size(min = 32, max = 32)
    private String id;
    @NotNull @Size(min = 3, max = 30)
    private String name;
    @NotNull @Size(min = 0)
    private Integer orderNum;

    public TaskPriority() {}

    public TaskPriority(String id, String name, int orderNum) {
        this.id = id;
        this.name = name;
        this.orderNum = orderNum;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getOrderNum() { return orderNum; }
    public void setOrderNum(Integer orderNum) { this.orderNum = orderNum; }
}