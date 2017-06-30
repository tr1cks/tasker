package com.github.tr1cks.tasker.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person implements DomainObj {
    @NotNull @Size
    private String id;

    @NotNull @Email @Size(min = 10, max = 200)
    private String email;
    @NotNull @Size(min = 3, max = 30)
    private String password;
    @NotNull @Size(min = 3, max = 30)
    private String firstName;
    @NotNull @Size(min = 3, max = 30)
    private String lastName;
    @NotNull
    private Boolean removed;

    public Person() {}

    public Person(String id, String password, String email, String firstName, String lastName) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() { return firstName + ' ' + lastName; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Boolean getRemoved() { return removed; }
    public void setRemoved(Boolean removed) { this.removed = removed; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!email.equals(person.email)) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!id.equals(person.id)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!password.equals(person.password)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();

        return result;
    }

    @Override public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("password", password)
                .add("email", email)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .toString();
    }
}