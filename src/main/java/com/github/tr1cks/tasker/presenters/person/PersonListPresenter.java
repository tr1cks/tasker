package com.github.tr1cks.tasker.presenters.person;

import com.github.tr1cks.tasker.dao.PersonDAO;
import com.github.tr1cks.tasker.domain.Person;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class PersonListPresenter implements Serializable {
    @Inject private PersonDAO personDAO;

    public Collection<Person> getPersons() { return personDAO.findAll(); }

    //TODO: do redirect after not-idempotent action
    public void delete(Person person) { personDAO.delete(person); }
}