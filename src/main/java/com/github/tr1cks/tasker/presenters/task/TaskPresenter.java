package com.github.tr1cks.tasker.presenters.task;

import com.github.tr1cks.tasker.dao.*;
import com.github.tr1cks.tasker.domain.*;
import com.github.tr1cks.tasker.presenters.AuthPresenter;

import javax.annotation.Nullable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class TaskPresenter implements Serializable {
    @Inject private PersonDAO personDAO;
    @Inject private TaskDAO taskDAO;
    @Inject private TaskTypeDAO taskTypeDAO;
    @Inject private TaskPriorityDAO taskPriorityDAO;
    @Inject private ProjectDAO projectDAO;
    @Inject private WorkLogEntryDAO workLogDAO;
    @Inject private TaskCommentDAO taskCommentDAO;
    @Inject private AuthPresenter authPresenter;

    private String id;
    private Task task;
    private Project project;
    private List<TaskComment> comments;
    private List<WorkLogEntry> workLog;
    private Integer loggedTimeInHours;

    private TaskComment newTaskComment;
    private WorkLogEntry newWorkLogEntry;

    public void load() {
        task = taskDAO.findById(id);
        comments = taskCommentDAO.findByTaskId(id);
        workLog = workLogDAO.findByTaskId(id);
        project = loadProject();
        loggedTimeInHours = computateSpentTime(workLog);

        newWorkLogEntry = newWorkLogEntry();
        newTaskComment = newTaskComment();
    }

    private Project loadProject() {
        @Nullable Project project = projectDAO.findById(task.getProjectId());
        if(project == null) throw new IllegalStateException();

        return project;
    }

    private Integer computateSpentTime(List<WorkLogEntry> workLog) {
        Integer spentTime = 0;
        for(WorkLogEntry workLogEntry : workLog) {
            spentTime += workLogEntry.getHours();
        }

        return spentTime;
    }

    public Person findPerson(String personId) {
        return personDAO.findById(personId);
    }

    public TaskType findType(String typeId) {
        return taskTypeDAO.findById(typeId);
    }

    public TaskPriority findPriority(String priorityId) {
        return taskPriorityDAO.findById(priorityId);
    }

    public void close() {
        task.setClosed(true);
        taskDAO.update(task);
    }

    public void reopen() {
        task.setClosed(false);
        taskDAO.update(task);
    }

    //TODO: add redirect, action isn't idempotent
    public void addTaskComment() {
        taskCommentDAO.save(newTaskComment);
        comments.add(0, newTaskComment);
        newTaskComment = newTaskComment();
    }

    //TODO: add redirect, action isn't idempotent
    public void addWorkLogEntry() {
        workLogDAO.save(newWorkLogEntry);

        workLog.add(0, newWorkLogEntry);
        loggedTimeInHours += newWorkLogEntry.getHours();

        newWorkLogEntry = newWorkLogEntry();
    }

    private TaskComment newTaskComment() {
        TaskComment taskComment = new TaskComment();
        taskComment.setTaskId(id);
        taskComment.setCreated(new Date());
        taskComment.setAuthorId(getCurrentPersonId());

        return taskComment;
    }

    private WorkLogEntry newWorkLogEntry() {
        WorkLogEntry newWorkLogEntry = new WorkLogEntry();
        newWorkLogEntry.setTaskId(id);
        newWorkLogEntry.setCreated(new Date());
        newWorkLogEntry.setAuthorId(getCurrentPersonId());

        return newWorkLogEntry;
    }

    private String getCurrentPersonId() {
        @Nullable Person person = authPresenter.getPerson();
        if(person == null) throw new IllegalStateException();

        return person.getId();
    }

    public Project getProject() { return project; }

    public List<TaskComment> getComments() { return comments; }

    public List<WorkLogEntry> getWorkLog() { return workLog; }

    public Integer getLoggedTimeInHours() { return loggedTimeInHours; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    public TaskComment getNewTaskComment() { return newTaskComment; }
    public void setNewTaskComment(TaskComment newTaskComment) { this.newTaskComment = newTaskComment; }

    public WorkLogEntry getNewWorkLogEntry() { return newWorkLogEntry; }
    public void setNewWorkLogEntry(WorkLogEntry newWorkLogEntry) { this.newWorkLogEntry = newWorkLogEntry; }
}