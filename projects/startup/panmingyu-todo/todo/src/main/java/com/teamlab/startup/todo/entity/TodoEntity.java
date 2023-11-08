package com.teamlab.startup.todo.entity;

import com.teamlab.startup.todo.form.TodoForm;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate deadline;
    private boolean status;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    // Constructors, getters, and setters...

    // Static method to create a TodoEntity from a TodoForm
    public static TodoEntity of(TodoForm todoForm) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoForm.getTitle());
        todoEntity.setDeadline(todoForm.getDeadline());
        todoEntity.setStatus(false); // Assuming new tasks have a status of "false"
        // The createTime and updateTime fields will be automatically set by the database due to annotations.
        return todoEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

}

