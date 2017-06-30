package com.github.tr1cks.tasker.dao;

import com.github.tr1cks.tasker.domain.WorkLogEntry;

import java.util.List;

public interface WorkLogEntryDAO extends CrudDAO<WorkLogEntry> {

    // Sorted by creation dateTime in descending order
    List<WorkLogEntry> findByTaskId(String taskId);
}
