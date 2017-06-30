package com.github.tr1cks.tasker.presenters.task;

import com.github.tr1cks.tasker.dao.PersonDAO;
import com.github.tr1cks.tasker.dao.TaskDAO;
import com.github.tr1cks.tasker.dao.TaskPriorityDAO;
import com.github.tr1cks.tasker.dao.TaskTypeDAO;
import com.github.tr1cks.tasker.domain.Task;
import com.github.tr1cks.tasker.domain.TaskPriority;
import com.github.tr1cks.tasker.domain.TaskType;
import com.github.tr1cks.tasker.domain.Person;

import javax.annotation.Nullable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Named
@ViewScoped
public class TaskAddEditPresenter implements Serializable {
    @Inject private TaskDAO taskDAO;
    @Inject private TaskPriorityDAO taskPriorityDAO;
    @Inject private TaskTypeDAO taskTypeDAO;
    @Inject private PersonDAO personDAO;

    private String projectId;
    private @Nullable String id;
    private Task task;

    public String addOrEdit() {
        if(task.getId() == null) {
            task.setClosed(false);
            taskDAO.save(task);
        } else {
            taskDAO.update(task);
        }

        return "project?id=" + projectId + "&faces-redirect=true";
    }

    public Collection<Person> getPersons() {
        return personDAO.findAll();
    }

    public List<TaskPriority> getPriorities() {
        return taskPriorityDAO.findAll();
    }

    public List<TaskType> getTypes() {
        return taskTypeDAO.findAll();
    }

    public void loadOrCreate() { task = id == null ? new Task(projectId) : taskDAO.findById(id); }

    public String getAction() { return id == null ? "Add" : "Edit"; }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public @Nullable String getId() {return id; }
    public void setId(@Nullable String id) { this.id = id; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }
}