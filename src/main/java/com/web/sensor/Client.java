package com.web.sensor;

import com.web.sensor.dto.MeasurementDTO;
import com.web.sensor.dto.SensorDTO;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Random;

public class Client {

    // or maybe write as integration test?
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        Random random = new Random();
        var sensor = new SensorDTO("test sensor" + random.nextInt());
        template.postForEntity("http://localhost:8080/sensors/registration", sensor, SensorDTO.class);
        for (int i = 0; i < 1000; i++) {
            var temp = random.ints(-100, 100).findFirst().getAsInt();
            var measurement = new MeasurementDTO(temp, random.nextBoolean(), sensor);
            template.postForEntity("http://localhost:8080/measurements/add", measurement, MeasurementDTO.class);
        }
        Arrays.stream(template.getForEntity("http://localhost:8080/measurements", MeasurementDTO[].class).getBody())
                .toList()
                .forEach(System.out::println);
    }
}
