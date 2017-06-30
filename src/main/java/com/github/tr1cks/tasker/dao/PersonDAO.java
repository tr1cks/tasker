package com.github.tr1cks.tasker.dao;

import com.github.tr1cks.tasker.domain.Person;

import javax.annotation.Nullable;

public interface PersonDAO extends CrudDAO<Person> {

    @Nullable
    Person findByEmailAndPassword(String email, String password);
}
