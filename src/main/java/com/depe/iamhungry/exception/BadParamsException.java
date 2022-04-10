package com.depe.iamhungry.exception;

public class BadParamsException extends RuntimeException {

    public BadParamsException() {
        super("query params: name is required, limit(must be greater than 0) and start(must be greater than -1) are optional but limit + start must not be greater than 500");
    }
}
