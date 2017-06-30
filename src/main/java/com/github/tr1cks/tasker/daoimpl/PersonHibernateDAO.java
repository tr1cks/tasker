package com.github.tr1cks.tasker.daoimpl;

import com.github.tr1cks.tasker.dao.PersonDAO;
import com.github.tr1cks.tasker.domain.Person;
import org.hibernate.Session;

import javax.annotation.Nullable;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonHibernateDAO extends AbstractHibernateDAO<Person> implements PersonDAO {

    public PersonHibernateDAO() {
        super(Person.class);
    }

    @Override public @Nullable
    Person findByEmailAndPassword(final String email, final String password) {
        @Nullable Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            @Nullable Person foundPerson = (Person) session.getNamedQuery("personByEmailAndPassword")
                                                     .setString("email", email)
                                                     .setString("password", password)
                                                     .uniqueResult();
            session.getTransaction().commit();

            return foundPerson;
        } catch(RuntimeException exc) {
            if(session != null) session.getTransaction().rollback();

            throw new RuntimeException(exc);
        }
    }

    @Override public void delete(Person person) {
        person.setRemoved(true);
        update(person);
    }
}