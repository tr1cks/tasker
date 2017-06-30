package com.github.tr1cks.tasker.presenters.project;

import com.github.tr1cks.tasker.dao.*;
import com.github.tr1cks.tasker.domain.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class ProjectPresenter implements Serializable {
    @Inject private TaskDAO taskDAO;
    @Inject private PersonDAO personDAO;
    @Inject private TaskTypeDAO taskTypeDAO;
    @Inject private TaskPriorityDAO taskPriorityDAO;
    @Inject private ProjectDAO projectDAO;

    private String id;
    private Project project;

    public void load() {
        project = projectDAO.findById(id);
    }

    public Collection<Task> getTasks() { return taskDAO.findByProjectId(id); }

    public TaskType getType(String typeId) {
        return taskTypeDAO.findById(typeId);
    }

    public TaskPriority getPriority(String priorityId) {
        return taskPriorityDAO.findById(priorityId);
    }

    public Person getPerson(String personId) {
        return personDAO.findById(personId);
    }

    //TODO: do redirect after not-idempotent action
    public void delete(Task task) { taskDAO.delete(task); }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}