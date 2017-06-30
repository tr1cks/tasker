package com.github.tr1cks.tasker.presenters.project;

import com.github.tr1cks.tasker.dao.ProjectDAO;
import com.github.tr1cks.tasker.domain.Project;

import javax.annotation.Nullable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ProjectAddEditPresenter implements Serializable {
    @Inject private ProjectDAO projectDAO;

    private @Nullable String id;
    private Project project;

    public String addOrEdit() {
        if(project.getId() == null) {
            projectDAO.save(project);
        } else {
            projectDAO.update(project);
        }

        return "projects?faces-redirect=true";
    }

    public void loadOrCreate() { project = id == null ? new Project() : projectDAO.findById(id); }

    public String getAction() { return id == null ? "Add" : "Edit"; }

    public @Nullable String getId() {return id; }
    public void setId(@Nullable String id) { this.id = id; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}
