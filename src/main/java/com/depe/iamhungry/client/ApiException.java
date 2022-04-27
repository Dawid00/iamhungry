package com.depe.iamhungry.client;

public class ApiException extends RuntimeException {
    public ApiException() {
        super("Yummly api doesnt not response appropriate body");
    }
}
