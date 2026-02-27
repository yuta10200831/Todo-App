package com.example.todo.domain.task;

import java.util.List;

public record TaskSearchCondition(
        String summary,
        List<TaskStatus> status,
        String sortBy  // "PRIORITY" の場合、優先度順でソート
) {
}
