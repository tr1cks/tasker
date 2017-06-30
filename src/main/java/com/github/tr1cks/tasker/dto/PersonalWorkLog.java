package com.github.tr1cks.tasker.dto;

import java.io.Serializable;

public class PersonalWorkLog implements Serializable {
    private String taskId;
    private Integer hours;

    public PersonalWorkLog() {}

    public String getTaskId() { return taskId; }
    public void setTaskId(String taskId) { this.taskId = taskId; }

    public Integer getHours() { return hours; }
    public void setHours(Integer hours) { this.hours = hours; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalWorkLog)) return false;

        PersonalWorkLog that = (PersonalWorkLog) o;

        if (!hours.equals(that.hours)) return false;
        if (!taskId.equals(that.taskId)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = taskId.hashCode();
        result = 31 * result + hours.hashCode();
        return result;
    }
}