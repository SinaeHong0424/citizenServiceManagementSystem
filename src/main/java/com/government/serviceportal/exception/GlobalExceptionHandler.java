package com.government.serviceportal.exception;

import com.government.serviceportal.dto.CommonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CommonDto.ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        CommonDto.ErrorResponse error = new CommonDto.ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<CommonDto.ErrorResponse> handleResourceAlreadyExists(ResourceAlreadyExistsException ex) {
        CommonDto.ErrorResponse error = new CommonDto.ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Conflict",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<CommonDto.ErrorResponse> handleUnauthorizedAccess(UnauthorizedAccessException ex) {
        CommonDto.ErrorResponse error = new CommonDto.ErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                "Forbidden",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonDto.ErrorResponse> handleGlobalException(Exception ex) {
        CommonDto.ErrorResponse error = new CommonDto.ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}