package com.web.sensor.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO {

    @Min(value = -100, message = "Temperature can not be less than -100")
    @Max(value = 100, message = "Temperature can not be more than 100")
    private int value;

    @NotNull
    private boolean isRaining;

    @NotNull
    private SensorDTO sensor;

}
