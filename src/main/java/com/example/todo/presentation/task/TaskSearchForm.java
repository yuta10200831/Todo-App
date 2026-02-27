package com.example.todo.presentation.task;

import com.example.todo.domain.task.TaskSearchCondition;
import com.example.todo.domain.task.TaskStatus;

import java.util.List;
import java.util.Optional;

public record TaskSearchForm(
        String summary,
        List<String> status,
        String sortBy  // "PRIORITY" で優先度順ソート
) {
    public TaskSearchCondition toCondition() {
        var statusList = Optional.ofNullable(status())
                .map(l -> l.stream().map(TaskStatus::valueOf).toList())
                .orElse(List.of());

        return new TaskSearchCondition(summary(), statusList, sortBy() != null ? sortBy() : "PRIORITY");
    }

    public TaskSearchDTO toDTO() {
        return new TaskSearchDTO(summary(), status(), sortBy());
    }
}
