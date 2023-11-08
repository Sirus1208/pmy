package com.teamlab.startup.todo.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TodoForm {

    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;

    /**
     * Titleの取得
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Titleの設定
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Deadlineの取得
     * @return deadline
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * Deadlineの設定
     * @param deadline 期限
     */
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
