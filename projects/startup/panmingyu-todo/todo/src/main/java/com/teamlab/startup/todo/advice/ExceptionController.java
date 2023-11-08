package com.teamlab.startup.todo.advice;

import com.teamlab.startup.todo.exception.ToDoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ControllerAdvice
public class ExceptionController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);
    @ExceptionHandler(ToDoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleToDoNotFoundException(ToDoNotFoundException exception) {
        log.warn("ToDoが見つかりません: " + exception.getMessage());


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/404");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleGenericException(Exception exception) {
        // ログ出力
        log.error("エラーが発生しました: " + exception.getMessage());

        // エラーページへの遷移
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/500");
        return modelAndView;
    }
}

