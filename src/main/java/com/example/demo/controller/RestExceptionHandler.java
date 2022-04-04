package com.example.demo.controller;

import com.example.demo.dto.ErrorDto;
import com.example.demo.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorDto> handleCourtsFullException(BaseException exception) {
        return ResponseEntity.badRequest().body(ErrorDto.builder().code(exception.getCode()).message(exception.getMessage()).build());
    }
}
