package com.depromeet.humming.weather.service;

import com.depromeet.humming.weather.model.WeatherStatus;
import org.springframework.stereotype.Component;

@Component
public class WeatherStatusProvider {

    public WeatherStatus provide(String status) {
        switch (status) {
            case "SUN":
                return WeatherStatus.SUN;
            case "CLOUD":
                return WeatherStatus.CLOUD;
            case "RAIN":
                return WeatherStatus.RAIN;
            case "SNOW":
                return WeatherStatus.SNOW;
            default:
                throw new IllegalArgumentException("Invalid status string : " + status);
        }
    }
}
