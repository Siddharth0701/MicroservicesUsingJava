package com.singh.user.service.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.singh.user.service.userservice.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception) {
        String message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND)
                .build();
        // ApiResponse.builder().message(message).success(true).status(HttpStatus)

        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);

    }

}
