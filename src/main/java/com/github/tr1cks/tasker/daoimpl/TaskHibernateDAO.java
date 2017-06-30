package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.dao.TaskCommentDAO;
import com.github.tr1cks.tasker.dao.TaskDAO;
import com.github.tr1cks.tasker.domain.Task;
import com.github.tr1cks.tasker.domain.TaskComment;
import com.github.tr1cks.tasker.domain.WorkLogEntry;
import com.github.tr1cks.tasker.dto.PersonalWorkLog;
import com.github.tr1cks.tasker.dao.WorkLogEntryDAO;
import org.hibernate.Session;

import javax.annotation.Nullable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newLinkedList;
import static org.hibernate.transform.Transformers.aliasToBean;

@ApplicationScoped
public class TaskHibernateDAO extends AbstractHibernateDAO<Task> implements TaskDAO {
    @Inject private TaskCommentDAO taskCommentDAO;
    @Inject private WorkLogEntryDAO workLogDAO;

    public TaskHibernateDAO() {
        super(Task.class);
    }

    @Override public void delete(Task task) {
        String taskId = task.getId();
        for(TaskComment taskComment : taskCommentDAO.findByTaskId(taskId)) {
            taskCommentDAO.delete(taskComment);
        }
        for(WorkLogEntry workLogEntry : workLogDAO.findByTaskId(taskId)) {
            workLogDAO.delete(workLogEntry);
        }
        super.delete(task);
    }

    @SuppressWarnings("unchecked")
    @Override public List<Task> findByProjectId(final String projectId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<Task> tasks = (List<Task>) session.getNamedQuery("tasksByProjectId")
                                                           .setString("projectId", projectId)
                                                           .list();
            session.getTransaction().commit();

            return tasks;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @SuppressWarnings("unchecked")
    @Override public List<Task> findByPersonId(final String personId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<Task> tasks = (List<Task>) session.getNamedQuery("tasksByPersonId")
                                                   .setString("assigneeId", personId)
                                                   .list();
            session.getTransaction().commit();

            return tasks;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @SuppressWarnings("unchecked")
    @Override public List<Task> findByUserProjectTypePriority(String personId, String projectId,
                                                              @Nullable String taskTypeId, @Nullable String taskPriorityId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<Task> tasks = (List<Task>) session.getNamedQuery("tasksByUserProjectTypePriority")
                                                   .setString("userId", personId)
                                                   .setString("projectId", projectId)
                                                   .setString("taskTypeId", taskTypeId)
                                                   .setString("taskPriorityId", taskPriorityId)
                                                   .list();
            session.getTransaction().commit();

            return tasks;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @SuppressWarnings("unchecked")
    @Override public List<PersonalWorkLog> personalWorkLog(String personId, String projectId,
                                                           @Nullable String taskTypeId, @Nullable String taskPriorityId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<PersonalWorkLog> personalWorkLog = session.getNamedQuery("personalWorkLog")
                                                           .setString("userId", personId)
                                                           .setString("projectId", projectId)
                                                           .setString("taskTypeId", taskTypeId)
                                                           .setString("taskPriorityId", taskPriorityId)
                                                           .setResultTransformer(aliasToBean(PersonalWorkLog.class))
                                                           .list();
            session.getTransaction().commit();

            return personalWorkLog;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @SuppressWarnings("unchecked")
    @Override public Integer workSummary(String personId, String projectId,
                                         @Nullable String taskTypeId, @Nullable String taskPriorityId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            Integer worked = (Integer) session.getNamedQuery("workSummary")
                                              .setString("userId", personId)
                                              .setString("projectId", projectId)
                                              .setString("taskTypeId", taskTypeId)
                                              .setString("taskPriorityId", taskPriorityId)
                                              .uniqueResult();
            session.getTransaction().commit();

            return worked;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @SuppressWarnings("unchecked")
    @Override public Integer closedTasks(String personId, String projectId,
                                         @Nullable String taskTypeId, @Nullable String taskPriorityId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            Integer closed = (Integer) session.getNamedQuery("closedTasks")
                                              .setString("userId", personId)
                                              .setString("projectId", projectId)
                                              .setString("taskTypeId", taskTypeId)
                                              .setString("taskPriorityId", taskPriorityId)
                                              .uniqueResult();
            session.getTransaction().commit();

            return closed;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }
}
