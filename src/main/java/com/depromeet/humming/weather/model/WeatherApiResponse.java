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
        private List<WeatherInfo> weather;

        @JsonCreator
        public WeatherData(@JsonProperty("weather") List<WeatherInfo> weather) {
            this.weather = weather;
        }
    }

    @Getter
    public static class WeatherInfo {
        private final String type;
        private final String description;

        @JsonCreator
        public WeatherInfo(@JsonProperty("main") String type, @JsonProperty("description") String description) {
            this.type = type;
            this.description = description;
        }
    }
}
