package com.example.todo.infrastructure.user.mybatis;

import com.example.todo.domain.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Insert("""
            INSERT INTO users (username, password, authority)
            VALUES (#{user.username}, #{user.password}, #{user.authority})
            """)
    void insert(@Param("user") User user);

    @Select("SELECT * FROM users WHERE username = #{username}")
    Optional<User> findByUsername(@Param("username") String username);
}
