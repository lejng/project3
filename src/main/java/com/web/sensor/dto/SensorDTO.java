package com.web.sensor.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SensorDTO {

    @NotEmpty(message = "Sensor name cannot be null")
    private String name;

}
