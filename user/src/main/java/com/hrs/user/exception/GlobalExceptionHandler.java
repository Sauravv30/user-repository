package com.hrs.user.exception;

import com.hrs.user.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle not found exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<Error> handleNotFoundException(NotFoundCustomException exception){
        return  new ResponseEntity<>(new Error().errorCode(404).errorMessage(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

}
