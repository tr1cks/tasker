package com.github.tr1cks.tasker.presenters.reports;

import com.github.tr1cks.tasker.dao.*;
import com.github.tr1cks.tasker.domain.*;
import com.github.tr1cks.tasker.dto.PersonalWorkLog;
import com.google.common.base.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Iterables.find;

@Named
@RequestScoped
public class TimeSpentReportPresenter implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(TimeSpentReportPresenter.class);

    @Inject private PersonDAO personDAO;
    @Inject private ProjectDAO projectDAO;
    @Inject private TaskDAO taskDAO;
    @Inject private TaskTypeDAO taskTypeDAO;
    @Inject private TaskPriorityDAO taskPriorityDAO;

    @NotNull
    private String personId;
    @NotNull
    private String projectId;
    private @Nullable String taskTypeId;
    private @Nullable String taskPriorityId;

    private List<Task> tasks;
    private List<PersonalWorkLog> personalWorkLog;
    private Integer workSummary;
    private Integer closedTasks;

    public void buildReport() {
        logger.info("Building report with params: personId={}, projectId={}, taskTypeId={}, taskPriorityId={}",
                    personId, projectId, taskTypeId, taskPriorityId);
        //TODO: hack for fixing inconsistent Tomcat 7.0.50 behavior
        taskTypeId = !isNullOrEmpty(taskTypeId) ? taskTypeId : null;
        taskPriorityId = !isNullOrEmpty(taskPriorityId) ? taskPriorityId : null;

        tasks = taskDAO.findByUserProjectTypePriority(personId, projectId, taskTypeId, taskPriorityId);
        personalWorkLog = taskDAO.personalWorkLog(personId, projectId, taskTypeId, taskPriorityId);
        workSummary = taskDAO.workSummary(personId, projectId, taskTypeId, taskPriorityId);
        closedTasks = taskDAO.closedTasks(personId, projectId, taskTypeId, taskPriorityId);
    }

    public Integer worked(final String taskId) {
        return find(personalWorkLog, new Predicate<PersonalWorkLog>() {
            @Override public boolean apply(PersonalWorkLog personalWorkLogEntry) {
                return personalWorkLogEntry.getTaskId().equals(taskId);
            }
        }).getHours();
    }

    public List<Person> getPersons() {
        return personDAO.findAll();
    }

    public List<Project> getProjects() {
        return projectDAO.findAll();
    }

    public List<TaskType> getTaskTypes() {
        return taskTypeDAO.findAll();
    }

    public List<TaskPriority> getTaskPriorities() {
        return taskPriorityDAO.findAll();
    }

    public TaskType getType(String taskTypeId) {
        return taskTypeDAO.findById(taskTypeId);
    }

    public TaskPriority getPriority(String taskPriorityId) {
        return taskPriorityDAO.findById(taskPriorityId);
    }

    public List<Task> getTasks() { return tasks; }

    public Integer getWorkSummary() { return workSummary; }

    public Integer getClosedTasks() { return closedTasks; }

    public String getPersonId() { return personId; }
    public void setPersonId(String personId) { this.personId = personId; }

    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public @Nullable String getTaskTypeId() { return taskTypeId; }
    public void setTaskTypeId(@Nullable String taskTypeId) { this.taskTypeId = taskTypeId; }

    public @Nullable String getTaskPriorityId() { return taskPriorityId; }
    public void setTaskPriorityId(@Nullable String taskPriorityId) { this.taskPriorityId = taskPriorityId; }
}