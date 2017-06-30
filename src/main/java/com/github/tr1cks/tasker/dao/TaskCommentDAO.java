package com.github.tr1cks.tasker.dao;

import com.github.tr1cks.tasker.domain.TaskComment;

import java.util.List;

public interface TaskCommentDAO extends CrudDAO<TaskComment> {

    // Sorted by creation dateTime in descending order
    List<TaskComment> findByTaskId(String taskId);
}