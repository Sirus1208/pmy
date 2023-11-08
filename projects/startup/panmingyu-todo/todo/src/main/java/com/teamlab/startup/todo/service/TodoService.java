package com.teamlab.startup.todo.service;

import com.teamlab.startup.todo.entity.TodoEntity; // 修改为TodoEntity
import com.teamlab.startup.todo.form.TodoForm;
import com.teamlab.startup.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoEntity> findAllTodo() { // 修改为TodoEntity
        return todoRepository.findAll();
    }

    public TodoEntity saveTodo(TodoForm todoForm) { // 修改为TodoEntity
        TodoEntity todo = new TodoEntity(); // 修改为TodoEntity
        todo.setTitle(todoForm.getTitle());
        todo.setDeadline(todoForm.getDeadline());
        todo.setStatus(false); // 修改为TodoEntity
        return todoRepository.save(todo);
    }

    public TodoEntity findTodoById(Long id) { // 修改为TodoEntity
        return todoRepository.findById(id).orElse(null);
    }

    public void updateTodo(Long id, TodoForm todoForm) {
        TodoEntity todo = findTodoById(id);
        if (todo != null) {
            todo.setTitle(todoForm.getTitle());
            todo.setDeadline(todoForm.getDeadline());
            todoRepository.save(todo);
        }
    }

    public List<TodoEntity> findTodosByTitle(String title) { // 修改为TodoEntity
        return todoRepository.findByTitleContaining(title);
    }

    public void toggleTodoStatus(Long id) {
        TodoEntity todo = findTodoById(id);
        if (todo != null) {
            todo.setStatus(!todo.isStatus()); // 修改为TodoEntity
            todoRepository.save(todo);
        }
    }
    public void saveTodoEntity(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
    }

    public List<TodoEntity> searchByTitle(String title) {
        return todoRepository.findByTitleContainingOrderByCreateTimeDesc(title);
    }

}

