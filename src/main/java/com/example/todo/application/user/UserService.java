package com.example.todo.application.user;

import com.example.todo.domain.user.User;
import com.example.todo.infrastructure.user.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(String username, String password, String authority) {
        // パスワードを暗号化する
        var encodedPassword = passwordEncoder.encode(password);
        var user = new User(username, encodedPassword, authority);
        userMapper.insert(user);
    }
}
