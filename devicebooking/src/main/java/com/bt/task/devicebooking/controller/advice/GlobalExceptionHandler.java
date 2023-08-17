package com.bt.task.devicebooking.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bt.task.devicebooking.exception.DeviceBookingException;
import com.bt.task.devicebooking.exception.DeviceNotFoundException;
import com.bt.task.devicebooking.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        var errorResponse = new ErrorResponse("500", "An error occurred. Please try again later.");

        // Return a ResponseEntity with an error message and status code
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(DeviceNotFoundException ex) {
        ex.printStackTrace();
        var errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getDescription());
        // Return a ResponseEntity with an error message and status code
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
    
    @ExceptionHandler(DeviceBookingException.class)
    public ResponseEntity<ErrorResponse> handleException(DeviceBookingException ex) {
        ex.printStackTrace();
        var errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getDescription());
        // Return a ResponseEntity with an error message and status code
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}
