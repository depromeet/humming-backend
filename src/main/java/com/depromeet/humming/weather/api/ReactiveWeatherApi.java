package com.depromeet.humming.weather.api;

import com.depromeet.humming.weather.model.Weather;
import reactor.core.publisher.Mono;

public interface ReactiveWeatherApi {

    Mono<Weather> getCurrentWeather(double latitude, double longitude);
}
