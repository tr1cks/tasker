package com.github.tr1cks.tasker.presenters.person;

import com.github.tr1cks.tasker.dao.*;
import com.github.tr1cks.tasker.domain.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class PersonPresenter implements Serializable {
    @Inject private TaskDAO taskDAO;
    @Inject private PersonDAO personDAO;
    @Inject private ProjectDAO projectDAO;
    @Inject private TaskTypeDAO taskTypeDAO;
    @Inject private TaskPriorityDAO taskPriorityDAO;

    private String id;
    private Person person;

    public void load() {
        person = personDAO.findById(id);
    }

    public Collection<Task> getTasks() { return taskDAO.findByPersonId(id); }

    public TaskType getType(String typeId) {
        return taskTypeDAO.findById(typeId);
    }

    public TaskPriority getPriority(String priorityId) {
        return taskPriorityDAO.findById(priorityId);
    }

    public Project getProject(String projectId) {
        return projectDAO.findById(projectId);
    }

    //TODO: do redirect after not-idempotent action
    public void delete(Task task) { taskDAO.delete(task); }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}