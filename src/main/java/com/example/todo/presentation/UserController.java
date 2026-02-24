package com.example.todo.presentation;

import com.example.todo.application.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // ユーザー登録画面を表示する
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup";
    }

    // ユーザー登録処理を行う
    @PostMapping("/signup")
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        userService.register(username, password, "USER");
        return "redirect:/login"; // 登録成功したらログイン画面へ
    }

    // ログイン画面を表示する
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
