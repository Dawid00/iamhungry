package com.depe.iamhungry.recipe;

public class RestServerException extends RuntimeException {
    public RestServerException() {
        super("Yummly api doesnt not response appropriate body");
    }
}
