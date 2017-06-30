package com.github.tr1cks.tasker.dao;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public interface DictionaryDAO<T> {

    // Sorted list
    List<T> findAll();
    @Nullable T findById(String domainObjId);
}