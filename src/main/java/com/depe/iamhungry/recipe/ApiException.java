package com.depe.iamhungry.recipe;

public class ApiException extends RuntimeException {
    public ApiException() {
        super("Yummly api doesnt not response appropriate body");
    }
}
