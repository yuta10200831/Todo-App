package com.example.todo.domain.task;

public record Task(
        Long id,
        String summary,
        String description,
        TaskStatus status
) {
}
