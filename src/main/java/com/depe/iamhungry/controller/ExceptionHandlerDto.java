package com.depe.iamhungry.controller;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExceptionHandlerDto {
    private String message;
    public ExceptionHandlerDto(String message) {
        this.message = message;
    }
}