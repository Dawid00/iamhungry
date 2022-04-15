package com.depe.iamhungry.controller;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExceptionMessageDto {
    private String message;
    public ExceptionMessageDto(String message) {
        this.message = message;
    }
}