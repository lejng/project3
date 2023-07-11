package com.web.sensor.controller;

import com.web.sensor.dto.SensorDTO;
import com.web.sensor.service.SensorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping("/registration")
    public ResponseEntity<SensorDTO> register(@Valid @RequestBody SensorDTO sensor) {
        return ResponseEntity.ok(service.add(sensor));
    }
}
