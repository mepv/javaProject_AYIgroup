package com.ayigroup.mepv.controller;

import com.ayigroup.mepv.exceptions.IdNotFoundException;
import com.ayigroup.mepv.exceptions.UserNameNotAvailableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(UserNameNotAvailableException.class)
    public String userNameError(UserNameNotAvailableException e, Model model) {
        String errorMessage = (e != null ? e.getMessage() : "Unknown error");
        model.addAttribute("error", errorMessage);
        return "username-error";
    }

    @ExceptionHandler(IdNotFoundException.class)
    public String idError(IdNotFoundException e, Model model) {
        String errorMessage = (e != null ? e.getMessage() : "Unknown error");
        model.addAttribute("error", errorMessage);
        return "id-error";
    }
}
