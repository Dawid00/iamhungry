package com.depe.iamhungry.recipe;

import com.depe.iamhungry.recipe.dto.ExceptionMessageDto;
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
    ExceptionMessageDto handleApiException(ApiException exception){
        return new ExceptionMessageDto(exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(BadParamsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ExceptionMessageDto handleBadParamsException(BadParamsException exception){
        return new ExceptionMessageDto(exception.getMessage());
    }

}