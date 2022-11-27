package com.informatica.github.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidRepoException extends RuntimeException {

    public InvalidRepoException(String message) {
        super(message);
    }
}
