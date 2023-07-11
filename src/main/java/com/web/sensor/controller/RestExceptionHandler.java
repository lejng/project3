package com.web.sensor.controller;

import com.web.sensor.dto.ErrorDTO;
import com.web.sensor.exception.SensorNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = SensorNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleSensorNotFoundException(SensorNotFoundException exception) {
        return ResponseEntity.badRequest().body(new ErrorDTO(exception.getMessage()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(new ErrorDTO(exception.getMessage()));
    }

}
