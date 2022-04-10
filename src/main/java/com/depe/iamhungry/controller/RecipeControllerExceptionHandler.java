package com.depe.iamhungry.controller;

import com.depe.iamhungry.recipe.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RecipeControllerExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    ExceptionHandlerDto handleApiException(ApiException exception){
        return new ExceptionHandlerDto(exception.getMessage());
    }
}