package com.depromeet.humming.weather.service;

import com.depromeet.humming.weather.api.ReactiveWeatherApi;
import com.depromeet.humming.weather.model.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final ReactiveWeatherApi reactiveWeatherApi;

    public Mono<Weather> getCurrentWeather(double latitude, double longitude) {
        return reactiveWeatherApi.getCurrentWeather(latitude, longitude);
    }
}
