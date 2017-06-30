package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.dao.CrudDAO;
import com.github.tr1cks.tasker.domain.DomainObj;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static com.github.tr1cks.tasker.util.UuidGen.newUuid;
import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newLinkedList;

public abstract class AbstractHibernateDAO<T extends DomainObj> implements CrudDAO<T>, Serializable {
    @Inject @Named("sessionFactory") protected SessionFactory sessionFactory;

    private final Class domainObjClass;

    protected AbstractHibernateDAO(Class domainObjClass) {
        this.domainObjClass = domainObjClass;
    }

    @Override public void save(T domainObj) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            domainObj.setId(newUuid());

            session.beginTransaction();
            session.save(domainObj);
            session.getTransaction().commit();
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @Override public void update(T domainObj) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            session.update(domainObj);
            session.getTransaction().commit();
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @Override public void delete(final T domainObj) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            session.delete(domainObj);
            session.getTransaction().commit();
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @SuppressWarnings("unchecked")
    @Override public List<T> findAll() {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            List<T> domainObjs = (List<T>) session.createCriteria(domainObjClass).list();
            session.getTransaction().commit();

            return domainObjs;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @SuppressWarnings("unchecked")
    @Override public @Nullable T findById(final String domainObjId) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            T domainObj = (T) session.get(domainObjClass, domainObjId);
            session.getTransaction().commit();

            return domainObj;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }
}
