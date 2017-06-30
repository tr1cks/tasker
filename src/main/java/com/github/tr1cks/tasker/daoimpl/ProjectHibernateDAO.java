package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.dao.ProjectDAO;
import com.github.tr1cks.tasker.dao.TaskDAO;
import com.github.tr1cks.tasker.domain.Project;
import com.github.tr1cks.tasker.domain.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newLinkedList;

@ApplicationScoped
public class ProjectHibernateDAO extends AbstractHibernateDAO<Project> implements ProjectDAO {
    @Inject private TaskDAO taskDAO;

    public ProjectHibernateDAO() {
        super(Project.class);
    }

    @Override public void delete(Project project) {
        String projectId = project.getId();
        for(Task task : taskDAO.findByProjectId(projectId)) {
            taskDAO.delete(task);
        }
        super.delete(project);
    }
}
