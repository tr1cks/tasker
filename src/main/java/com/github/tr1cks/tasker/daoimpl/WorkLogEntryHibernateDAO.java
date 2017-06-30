package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.domain.WorkLogEntry;
import com.github.tr1cks.tasker.dao.WorkLogEntryDAO;
import org.hibernate.Session;

import javax.annotation.Nullable;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newLinkedList;

@ApplicationScoped
public class WorkLogEntryHibernateDAO extends AbstractHibernateDAO<WorkLogEntry> implements WorkLogEntryDAO {

    public WorkLogEntryHibernateDAO() {
        super(WorkLogEntry.class);
    }

    @SuppressWarnings("unchecked")
    @Override public List<WorkLogEntry> findByTaskId(final String taskId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<WorkLogEntry> workLog = (List<WorkLogEntry>) session.getNamedQuery("workLogByTaskId")
                                                                     .setString("taskId", taskId)
                                                                     .list();
            session.getTransaction().commit();

            return workLog;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }
}