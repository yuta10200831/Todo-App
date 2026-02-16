package com.example.todo.presentation.task;

import com.example.todo.domain.task.Task;
import com.example.todo.domain.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record TaskForm(
        @NotBlank
        @Size(max = 256, message = "256文字以内で入力してください")
        String summary,
        String description,
        @NotBlank
        @Pattern(regexp="TODO|DOING|DONE", message = "Todo, Doing, Done のいずれかを選択してください")
        String status,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate deadline
) {
    public static TaskForm fromTask(Task task) {
        return new TaskForm(
                task.summary(),
                task.description(),
                task.status().name(),
                task.deadline()
        );
    }

    public Task toTask() {
        return new Task(null, summary(), description(), TaskStatus.valueOf(status()), deadline());
    }


    public Task toTask(long id) {
        return new Task(id, summary(), description(), TaskStatus.valueOf(status()), deadline());
    }
}
