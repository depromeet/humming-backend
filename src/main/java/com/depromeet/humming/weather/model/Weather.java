package com.depromeet.humming.weather.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Weather {

    private final WeatherStatus weatherStatus;
    private final String description;
}
