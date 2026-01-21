package com.example.todo.infrastructure.task;

import com.example.todo.domain.task.Task;
import com.example.todo.domain.task.TaskRepository;
import com.example.todo.domain.task.TaskSearchCondition;
import com.example.todo.infrastructure.task.mybatis.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskMapper taskMapper;

    @Override
    public List<Task> select(TaskSearchCondition condition) {
        return taskMapper.select(condition);
    }

    @Override
    public Optional<Task> selectById(long taskId) {
        return taskMapper.selectById(taskId);
    }

    @Override
    public void insert(Task task) {
        taskMapper.insert(task);
    }

    @Override
    public void update(Task task) {
        taskMapper.update(task);
    }

    @Override
    public void delete(long id) {
        taskMapper.delete(id);
    }
}
