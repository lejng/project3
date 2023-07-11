package com.web.sensor.service;

import com.web.sensor.dto.MeasurementDTO;
import com.web.sensor.dto.SensorDTO;
import com.web.sensor.entity.Measurement;
import org.springframework.stereotype.Service;

@Service
public class MeasurementDtoConverter {

    public MeasurementDTO convert(Measurement measurement) {
        var sensor = new SensorDTO(measurement.getSensor().getName());
        return new MeasurementDTO(measurement.getValue(), measurement.isRaining(), sensor);
    }

}
