package com.web.sensor.service;

import com.web.sensor.dto.SensorDTO;
import com.web.sensor.entity.Sensor;
import com.web.sensor.repository.SensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SensorService {

    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public SensorDTO add(SensorDTO dto) {
        var sensor = repository.save(new Sensor(dto.getName()));
        return new SensorDTO(sensor.getName());
    }

}
