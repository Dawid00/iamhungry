package com.depe.iamhungry.controller;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExceptionHandlerDto {
    private String message;
    public ExceptionHandlerDto(String message) {
        this.message = message;
    }
}