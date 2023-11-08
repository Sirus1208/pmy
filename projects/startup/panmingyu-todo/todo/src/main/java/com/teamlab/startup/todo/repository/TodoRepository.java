package com.teamlab.startup.todo.repository;

import com.teamlab.startup.todo.entity.TodoEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Todo Repository */
@Repository
@ComponentScan
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByTitleContainingOrderByCreateTimeDesc(String title);
    List<TodoEntity> findByTitleContaining(String title);

}
