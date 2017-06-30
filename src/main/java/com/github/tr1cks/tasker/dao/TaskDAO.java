package com.github.tr1cks.tasker.dao;

import com.github.tr1cks.tasker.dto.PersonalWorkLog;
import com.github.tr1cks.tasker.domain.Task;

import javax.annotation.Nullable;
import java.util.List;

public interface TaskDAO extends CrudDAO<Task> {

    List<Task> findByProjectId(final String projectId);
    List<Task> findByPersonId(final String personId);

    // Находит задачи по которым пользователь работал, а не назначенные ему
    List<Task> findByUserProjectTypePriority(String personId, String projectId,
                                             @Nullable String taskTypeId, @Nullable String taskPriorityId);

    List<PersonalWorkLog> personalWorkLog(String personId, String projectId,
                                          @Nullable String taskTypeId, @Nullable String taskPriorityId);

    Integer workSummary(String personId, String projectId,
                        @Nullable String taskTypeId, @Nullable String taskPriorityId);

    Integer closedTasks(String personId, String projectId,
                        @Nullable String taskTypeId, @Nullable String taskPriorityId);
}