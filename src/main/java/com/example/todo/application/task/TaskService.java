package com.example.todo.application.task;

import com.example.todo.domain.task.Task;
import com.example.todo.domain.task.TaskRepository;
import com.example.todo.domain.task.TaskSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> find(TaskSearchCondition condition) {
        return taskRepository.select(condition);
    }

    public Optional<Task> findById(long taskId) {
        return taskRepository.selectById(taskId);
    }

    @Transactional
    public void create(Task newTask) {
        taskRepository.insert(newTask);
    }

    @Transactional
    public void update(Task task) {
        taskRepository.update(task);
    }

    @Transactional
    public void delete(long id) {
        taskRepository.delete(id);
    }
}
