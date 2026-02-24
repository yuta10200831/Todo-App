package com.example.todo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .formLogin(login -> login
                .loginProcessingUrl("/login") // ログイン処理のパス
                .loginPage("/login")          // ログイン画面のパス
                .defaultSuccessUrl("/")       // ログイン成功後の遷移先
                .failureUrl("/login?error")   // ログイン失敗時の遷移先
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")
            )
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // cssなどはアクセスOK
                .requestMatchers(new AntPathRequestMatcher("/signup")).permitAll() // ★ユーザー登録画面はログインなしでOK
                .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                .anyRequest().authenticated() // それ以外はログイン必要
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // パスワードを暗号化する仕組み
    }
}
