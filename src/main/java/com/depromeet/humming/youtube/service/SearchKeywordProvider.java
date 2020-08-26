package com.depromeet.humming.youtube.service;

import com.depromeet.humming.weather.model.WeatherStatus;
import org.springframework.stereotype.Component;

@Component
public class SearchKeywordProvider {

    public String provide(WeatherStatus status) {
        switch (status) {
            case SUN:
                return "맑은 날에 들을만한 음악";
            case CLOUD:
                return "구름 많을 때 들을만한 음악";
            case RAIN:
                return "비오는 날 들을만한 음악";
            case SNOW:
                return "눈오는 날 들을만한 음악";
            default:
                throw new IllegalArgumentException();
        }
    }
}
