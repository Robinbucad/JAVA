package com.example.refactorCRUDbp.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError> notFoundException(NotFoundException notFoundException){
        CustomError customError = new CustomError(new Date(),notFoundException.getMessage(),404);
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableException.class)
    public final ResponseEntity<CustomError> unProcessableException(UnprocessableException unprocessableException){
        CustomError customError = new CustomError(new Date(), unprocessableException.getMessage(),422);
        return new ResponseEntity<>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
