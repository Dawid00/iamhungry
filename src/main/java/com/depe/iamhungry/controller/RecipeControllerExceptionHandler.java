package com.depe.iamhungry.controller;

import com.depe.iamhungry.exception.BadParamsException;
import com.depe.iamhungry.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RecipeControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    ExceptionHandlerDto handleApiException(ApiException exception){
        return new ExceptionHandlerDto(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BadParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionHandlerDto handleBadParamsException(ApiException exception){
        return new ExceptionHandlerDto(exception.getMessage());
    }

}