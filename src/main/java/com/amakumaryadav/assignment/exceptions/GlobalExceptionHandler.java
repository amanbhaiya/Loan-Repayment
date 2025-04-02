package com.amakumaryadav.assignment.exceptions;

import com.amakumaryadav.assignment.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        String error = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .toList().stream().findFirst().orElse("");

        ApiErrorResponse errorResponse = new ApiErrorResponse();
                errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                errorResponse.setError(error);
                errorResponse.setPath(request.getDescription(false).replace("uri=", ""));
                errorResponse.setTimestamp(LocalDateTime.now());
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

