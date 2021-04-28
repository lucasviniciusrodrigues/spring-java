package com.lab.person.onboarding.adapter.exception.handler;

import com.mongodb.MongoWriteException;
import org.springdoc.api.ErrorMessage;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
class PersonExceptionHandler {

    @ExceptionHandler(value = ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Object> badRequestNotFound(ChangeSetPersister.NotFoundException e){
        return new ResponseEntity<Object>(new ErrorMessage("Data not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Object> noSuchElementException(NoSuchElementException e){
        return new ResponseEntity<Object>(new ErrorMessage("Data not found"), HttpStatus.BAD_REQUEST);
    }



}