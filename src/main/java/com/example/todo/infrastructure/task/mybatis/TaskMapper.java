package com.example.todo.infrastructure.task.mybatis;

import com.example.todo.domain.task.Task;
import com.example.todo.domain.task.TaskSearchCondition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskMapper {

    @Select("""
            <script>
              SELECT id, summary, description, status
              FROM tasks
              <where>
                <if test='condition.summary != null and !condition.summary.isBlank()'>
                  summary LIKE CONCAT('%', #{condition.summary}, '%')
                </if>
                <if test='condition.status != null and !condition.status.isEmpty()'>
                  AND status IN (
                    <foreach item='item' index='index' collection='condition.status' separator=','>
                      #{item}
                    </foreach>
                  )
                </if>
              </where>
            </script>
            """)
    List<Task> select(@Param("condition") TaskSearchCondition condition);

    @Select("SELECT id, summary, description, status FROM tasks WHERE id = #{taskId}")
    Optional<Task> selectById(@Param("taskId") long taskId);

    @Insert("""
            INSERT INTO tasks (summary, description, status)
            VALUES (#{task.summary}, #{task.description}, #{task.status})
            """)
    void insert(@Param("task") Task task);

    @Update("""
            UPDATE tasks
            SET
              summary     = #{task.summary},
              description = #{task.description},
              status      = #{task.status}
            WHERE
              id = #{task.id}
            """)
    void update(@Param("task") Task task);

    @Delete("DELETE FROM tasks WHERE id = #{taskId}")
    void delete(@Param("taskId") long id);
}
