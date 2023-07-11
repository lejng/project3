package com.web.sensor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "measurement")
@Setter
@Getter
@NoArgsConstructor
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private int value;

    @Column(name = "raining")
    private boolean isRaining;

    @ManyToOne()
    @JoinColumn(name="sensor_id", referencedColumnName = "id", nullable = false)
    private Sensor sensor;

    public Measurement(int value, boolean isRaining, Sensor sensor) {
        this.value = value;
        this.isRaining = isRaining;
        this.sensor = sensor;
    }

}
