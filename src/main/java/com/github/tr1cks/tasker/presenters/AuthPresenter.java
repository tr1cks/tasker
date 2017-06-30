package com.github.tr1cks.tasker.presenters;

import com.github.tr1cks.tasker.dao.PersonDAO;
import com.github.tr1cks.tasker.domain.Person;

import javax.annotation.Nullable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AuthPresenter implements Serializable {
    @Inject private PersonDAO personDAO;

    private String email;
    private String password;

    private @Nullable
    Person person;

    public String login() {
        if(person != null) return "index?faces-redirect=true";

        @Nullable Person foundPerson = personDAO.findByEmailAndPassword(email, password);
        //TODO: null возвращать нельзя. Похоже на баг Mojarra 2.2.2
        if(foundPerson == null || foundPerson.getRemoved()) return "login";

        person = foundPerson;
        return "index?faces-redirect=true";
    }

    public @Nullable
    Person getPerson() { return person; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
