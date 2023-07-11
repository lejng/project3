package com.web.sensor.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MeasurementDTO {

    @Min(value = -100, message = "Temperature can not be less than -100")
    @Max(value = 100, message = "Temperature can not be more than 100")
    private int value;

    @NotNull
    private boolean isRaining;

    @NotNull
    private SensorDTO sensor;

}
