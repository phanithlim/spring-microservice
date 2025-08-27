package com.mlue.ecommerce.expection;

import com.mlue.ecommerce.core.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.error(hashCode(), ex.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.error(hashCode(), ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralError(Exception ex) {
        return ResponseEntity
                .ok()
                .body(ApiResponse.error(hashCode(), ex.getMessage()));
    }

}
