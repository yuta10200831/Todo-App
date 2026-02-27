package com.example.todo.domain.task;

import java.time.LocalDate;

public record Task(
        Long id,
        String summary,
        String description,
        TaskStatus status,
        TaskPriority priority,
        LocalDate deadline
) {
}
