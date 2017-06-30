package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.domain.TaskComment;
import com.github.tr1cks.tasker.dao.TaskCommentDAO;
import org.hibernate.Session;

import javax.annotation.Nullable;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

import static com.google.common.collect.Lists.newLinkedList;

@ApplicationScoped
public class TaskCommentHibernateDAO extends AbstractHibernateDAO<TaskComment> implements TaskCommentDAO {

    public TaskCommentHibernateDAO() {
        super(TaskComment.class);
    }

    @SuppressWarnings("unchecked")
    @Override public List<TaskComment> findByTaskId(final String taskId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<TaskComment> taskComments = (List<TaskComment>) session.getNamedQuery("taskCommentsByTaskId")
                                                                        .setString("taskId", taskId)
                                                                        .list();
            session.getTransaction().commit();

            return taskComments;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }
}