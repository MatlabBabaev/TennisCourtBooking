package com.example.demo.exception;

public class CourtsFullException extends BaseException {
    public static final int ERROR_CODE = 1001;
    public static final String ERROR_MESSAGE = "Courts are full";

    @Override
    public int getCode() {
        return ERROR_CODE;
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
