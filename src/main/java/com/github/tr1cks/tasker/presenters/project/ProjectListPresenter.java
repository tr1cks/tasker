package com.github.tr1cks.tasker.presenters.project;

import com.github.tr1cks.tasker.dao.ProjectDAO;
import com.github.tr1cks.tasker.domain.Project;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class ProjectListPresenter implements Serializable {
    @Inject private ProjectDAO projectDAO;

    public Collection<Project> getProjects() { return projectDAO.findAll(); }

    //TODO: do redirect after not-idempotent action
    public void delete(Project project) { projectDAO.delete(project); }
}