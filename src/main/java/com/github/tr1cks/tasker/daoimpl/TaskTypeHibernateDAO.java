package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.domain.TaskType;
import com.github.tr1cks.tasker.dao.TaskTypeDAO;

import javax.enterprise.context.ApplicationScoped;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.newLinkedList;

@ApplicationScoped
public class TaskTypeHibernateDAO extends AbstractHibernateDAO<TaskType> implements TaskTypeDAO {

    public TaskTypeHibernateDAO() {
        super(TaskType.class);
    }
}