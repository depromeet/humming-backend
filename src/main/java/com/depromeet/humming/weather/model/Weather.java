package com.depromeet.humming.weather.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Weather {

    private final String type;
    private final String description;

    @JsonCreator
    public Weather(@JsonProperty("main") String type, @JsonProperty("description") String description) {
        this.type = type;
        this.description = description;
    }
}
