package com.springdemo.springbootapi.error;

public class DepartNotFoundException extends Exception{
    public DepartNotFoundException() {
        super();
    }

    public DepartNotFoundException(String message) {
        super(message);
    }

    public DepartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
