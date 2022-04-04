package com.example.demo.exception;

public class OldDateException extends BaseException {
    public static final int ERROR_CODE = 1002;
    public static final String ERROR_MESSAGE = "Invalid date, choose today or any date in the future";

    @Override
    public int getCode() {
        return ERROR_CODE;
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}
