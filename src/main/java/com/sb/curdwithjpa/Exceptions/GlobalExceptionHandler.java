package com.sb.curdwithjpa.Exceptions;

import com.sb.curdwithjpa.response.APIResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(CustomerAlreadyExistException.class)
public ResponseEntity<APIResponse> handleCustomerNotExistsException(CustomerAlreadyExistException e){
        return ResponseEntity.ok(
                APIResponse.builder()
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .errorMessage(e.getMessage())
                        .build()
        );
    }
}
