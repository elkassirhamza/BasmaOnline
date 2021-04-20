package com.example.commandes.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommandeNotFountException extends RuntimeException {


    public CommandeNotFountException(String message) {
        super(message);
    }
}
