package com.example.todo.presentation;

import com.example.todo.application.task.TaskService;
import com.example.todo.domain.task.TaskSearchCondition;
import com.example.todo.presentation.task.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final TaskService taskService;

    // http:localhost:8080/ -> トップページを表示
    @GetMapping("/")
    public String index(Model model) {
        var taskList = taskService.find(new TaskSearchCondition(null, Collections.emptyList(), "PRIORITY"))
                .stream()
                .map(TaskDTO::toDTO)
                .toList();

        model.addAttribute("taskList", taskList);
        return "index";
    }
}
