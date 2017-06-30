package com.github.tr1cks.tasker.dao;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public interface CrudDAO<T> {
    void save(T domainObj);
    void update(T domainObj);
    void delete(T domainObj);

    List<T> findAll();
    @Nullable T findById(String domainObjId);
}