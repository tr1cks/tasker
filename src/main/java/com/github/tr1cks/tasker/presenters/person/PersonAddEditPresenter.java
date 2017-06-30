package com.github.tr1cks.tasker.presenters.person;

import com.github.tr1cks.tasker.dao.PersonDAO;
import com.github.tr1cks.tasker.domain.Person;

import javax.annotation.Nullable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PersonAddEditPresenter implements Serializable {
    @Inject private PersonDAO personDAO;

    private @Nullable String id;
    private Person person;

    public String addOrEdit() {
        if(person.getId() == null) {
            person.setRemoved(false);
            personDAO.save(person);
        } else {
            personDAO.update(person);
        }

        return "persons?faces-redirect=true";
    }

    public void loadOrCreate() { person = id == null ? new Person() : personDAO.findById(id); }

    public String getAction() { return id == null ? "Add" : "Edit"; }

    public @Nullable String getId() { return id; }
    public void setId(@Nullable String id) { this.id = id; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}