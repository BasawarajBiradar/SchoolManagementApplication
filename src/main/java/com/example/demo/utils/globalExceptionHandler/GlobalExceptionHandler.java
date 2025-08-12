package com.example.demo.utils.globalExceptionHandler;

import com.example.demo.utils.response.ResponseHandler;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        return ResponseHandler.error(errors, "ValidationError", "400");
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationErrors(ValidationException ex) {
        return ResponseHandler.error(ex.getMessage(), "ValidationError", "400");
    }
}

