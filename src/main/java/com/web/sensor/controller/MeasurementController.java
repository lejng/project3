package com.web.sensor.controller;

import com.web.sensor.dto.MeasurementDTO;
import com.web.sensor.service.MeasurementService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService service;

    public MeasurementController(MeasurementService service) {
        this.service = service;
    }

    @GetMapping
    public List<MeasurementDTO> findAll() {
        return service.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<MeasurementDTO> add(@Valid @RequestBody MeasurementDTO measurementDTO) {
        return ResponseEntity.ok(service.add(measurementDTO));
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> rainyDaysCount() {
        return ResponseEntity.ok(service.getRainyDaysCount());
    }

}
