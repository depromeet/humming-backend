package com.depromeet.humming.recommend.model;

import com.depromeet.humming.weather.model.WeatherStatus;
import com.depromeet.humming.youtube.model.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class RecommendResult {
    private WeatherStatus weatherStatus;
    private String weatherDescription;
    private String youtubeUrl;
    private List<Id> recommends;
}
