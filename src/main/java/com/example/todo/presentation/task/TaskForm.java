package com.example.todo.presentation.task;

import com.example.todo.domain.task.Task;
import com.example.todo.domain.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TaskForm(
        @NotBlank
        @Size(max = 256, message = "256文字以内で入力してください")
        String summary,
        String description,
        @NotBlank
        @Pattern(regexp="TODO|DOING|DONE", message = "Todo, Doing, Done のいずれかを選択してください")
        String status
) {
    public static TaskForm fromTask(Task task) {
        return new TaskForm(
                task.summary(),
                task.description(),
                task.status().name()
        );
    }

    public Task toTask() {
        return new Task(null, summary(), description(), TaskStatus.valueOf(status()));
    }


    public Task toTask(long id) {
        return new Task(id, summary(), description(), TaskStatus.valueOf(status()));
    }
}
