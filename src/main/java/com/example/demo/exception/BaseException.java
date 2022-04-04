package com.example.demo.exception;

public abstract class BaseException extends RuntimeException {
    public abstract int getCode();
    public abstract String getMessage();
}
