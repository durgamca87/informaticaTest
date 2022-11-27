package com.informatica.github.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GitRepoExceptionHandler {

    /*
        handler to handle exception when invalid url requests
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleNoHandlerFound(NoHandlerFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse = new ErrorResponse("INVALID_URL", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /*
        handler to handle exceptions when language query param is not passed in request url
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public final ResponseEntity<ErrorResponse> handleMissingServletReqParException(MissingServletRequestParameterException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("INCORRECT_REQUEST", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /*
       handler to handle exceptions when repo is found in GIT
    */
    @ExceptionHandler(value = MissingRepoException.class)
    public final ResponseEntity<ErrorResponse> handleMissingRepoException(MissingRepoException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("INCORRECT_REQUEST", details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /*
       handler to handle exceptions when language invalid language is passed in request url
    */
    @ExceptionHandler(value = InvalidRepoException.class)
    public final ResponseEntity<ErrorResponse> handleInvalidRepoException(InvalidRepoException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("BAD_REQUEST", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
