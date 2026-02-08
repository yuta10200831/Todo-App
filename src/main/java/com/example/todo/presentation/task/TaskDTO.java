package com.example.todo.presentation.task;

import com.example.todo.domain.task.Task;

import java.time.LocalDate;

public record TaskDTO(
        long id,
        String summary,
        String description,
        String status,
        LocalDate deadline
) {
    public static TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.id(),
                task.summary(),
                task.description(),
                task.status().name(),
                task.deadline()
        );
    }
}
