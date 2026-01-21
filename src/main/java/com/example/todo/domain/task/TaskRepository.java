package com.example.todo.domain.task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> select(TaskSearchCondition condition);
    Optional<Task> selectById(long taskId);
    void insert(Task task);
    void update(Task task);
    void delete(long id);
}
