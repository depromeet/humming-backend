package com.depromeet.humming.weather.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class WeatherApiResponse {

    private List<WeatherData> list;

    @JsonCreator
    public WeatherApiResponse(@JsonProperty("list") List<WeatherData> list) {
        this.list = list;
    }

    @Getter
    public static class WeatherData {
        private List<Weather> weather;

        @JsonCreator
        public WeatherData(@JsonProperty("weather") List<Weather> weather) {
            this.weather = weather;
        }
    }
}
