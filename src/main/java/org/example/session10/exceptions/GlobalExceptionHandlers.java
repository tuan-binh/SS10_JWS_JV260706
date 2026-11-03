package org.example.session10.exceptions;

import org.example.session10.models.dto.wrapper.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(
                ApiResponse.builder()
                        .code(400)
                        .message("FAILED")
                        .data(errors)
                        .build()
        );
    }

    @ExceptionHandler(HttpNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(HttpNotFoundException ex) {
        return ResponseEntity.status(404).body(
                ApiResponse.builder()
                        .code(404)
                        .message("NOT FOUND")
                        .data(ex.getMessage())
                        .build()
        );
    }

    // Liệt kê các exception khác nếu có muốn bắt nó lại

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        return ResponseEntity.status(500).body(
                ApiResponse.builder()
                        .code(500)
                        .message("INTERNAL SERVER ERROR")
                        .data(ex.getMessage())
                        .build()
        );
    }

}
