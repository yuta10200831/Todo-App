package com.example.todo.presentation.task;

import com.example.todo.domain.task.Task;

public record TaskDTO(
        long id,
        String summary,
        String description,
        String status
) {
    public static TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.id(),
                task.summary(),
                task.description(),
                task.status().name()
        );
    }
}
