package com.depe.iamhungry.recipe.dto;

public class ExceptionMessageDto {
    private String message;
    public ExceptionMessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}