
package com.studentmanagement.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle student not found exception
    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFound(
            StudentNotFoundException exception,
            Model model) {

        model.addAttribute("errorMessage", exception.getMessage());

        return "error";
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception exception, Model model) {
        model.addAttribute("errorMessage", "Something went wrong. Please try again later.");
        return "error";
    }
}
