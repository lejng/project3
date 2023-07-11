package com.web.sensor.service;

import com.web.sensor.dto.MeasurementDTO;
import com.web.sensor.entity.Measurement;
import com.web.sensor.exception.SensorNotFoundException;
import com.web.sensor.repository.MeasurementRepository;
import com.web.sensor.repository.SensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorRepository sensorRepository;

    private final MeasurementDtoConverter converter;

    public MeasurementService(MeasurementRepository measurementRepository,
                              SensorRepository sensorRepository,
                              MeasurementDtoConverter converter) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
        this.converter = converter;
    }

    @Transactional
    public long getRainyDaysCount() {
        return measurementRepository.findAll().stream().filter(Measurement::isRaining).count();
    }

    @Transactional
    public MeasurementDTO add(MeasurementDTO measurementDTO) {
        var sensor = sensorRepository.findByName(measurementDTO.getSensor().getName())
                .orElseThrow(SensorNotFoundException::new);
        var measurement = new Measurement(measurementDTO.getValue(), measurementDTO.isRaining(), sensor);
        measurementRepository.save(measurement);
        return measurementDTO;
    }

    @Transactional
    public List<MeasurementDTO> findAll() {
        return measurementRepository.findAll().stream().map(converter::convert).toList();
    }

}
