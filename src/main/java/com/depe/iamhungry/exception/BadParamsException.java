package com.depe.iamhungry.exception;

public class BadParamsException extends RuntimeException {

    public BadParamsException() {
        super("Query Params: name is required, limit and start are optional but limit + start must not be greater than 500");
    }
}
