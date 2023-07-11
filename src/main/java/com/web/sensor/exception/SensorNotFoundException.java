package com.web.sensor.exception;

public class SensorNotFoundException extends RuntimeException {

    public SensorNotFoundException() {
        super("Sensor not found");
    }
}
