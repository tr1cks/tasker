package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.domain.TaskPriority;
import com.github.tr1cks.tasker.dao.TaskPriorityDAO;

import javax.enterprise.context.ApplicationScoped;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;

@ApplicationScoped
public class TaskPriorityHibernateDAO extends AbstractHibernateDAO<TaskPriority> implements TaskPriorityDAO {

    public TaskPriorityHibernateDAO() {
        super(TaskPriority.class);
    }
}