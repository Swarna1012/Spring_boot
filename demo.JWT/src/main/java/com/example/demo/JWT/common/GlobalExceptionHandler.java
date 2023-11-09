package com.example.demo.JWT.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        APIResponse apiResponse = new APIResponse();
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        apiResponse.setError(errors);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @ExceptionHandler
    public ResponseEntity handleException(Exception e){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.setError("Oops...Something went wrong!");

        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }

    @ExceptionHandler
    public ResponseEntity handleAccessDeniedException(AccessDeniedException e){

        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        apiResponse.setError("Unauthorized Access Denied!");

        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

    }
}
