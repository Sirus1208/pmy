package com.teamlab.startup.todo.controller;
import com.teamlab.startup.todo.entity.TodoEntity;
import com.teamlab.startup.todo.form.TodoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.teamlab.startup.todo.service.TodoService;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<TodoEntity> todos = todoService.findAllTodo();
        model.addAttribute("todos", todos);
        model.addAttribute("newTodo", new TodoForm());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute("newTodo") TodoForm newTodo) {
        todoService.saveTodo(newTodo);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable Long id, Model model) {
        TodoEntity todo = todoService.findTodoById(id);
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute("todo") TodoForm updatedTodo) {
        todoService.updateTodo(id, updatedTodo);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "search";
    }

    @GetMapping("/search/result")
    public String searchTodo(@RequestParam("title") String title, Model model) {
        List<TodoEntity> todos = todoService.findTodosByTitle(title);
        model.addAttribute("todos", todos);
        return "search";
    }
    @PostMapping("/toggle-status/{id}")
    public String toggleTodoStatus(@PathVariable Long id) {
        TodoEntity todoEntity = todoService.findTodoById(id);
        if (todoEntity != null) {
            todoEntity.setStatus(!todoEntity.isStatus());
            todoService.saveTodoEntity(todoEntity);
        }
        return "redirect:/";
    }

}
