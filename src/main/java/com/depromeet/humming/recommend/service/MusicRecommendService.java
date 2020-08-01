package com.depromeet.humming.recommend.service;

import com.depromeet.humming.recommend.model.RecommendResult;
import com.depromeet.humming.weather.service.WeatherService;
import com.depromeet.humming.youtube.api.ReactiveYoutubeApi;
import com.depromeet.humming.youtube.service.SearchKeywordProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicRecommendService {

    private final SearchKeywordProvider searchKeywordProvider;
    private final WeatherService weatherService;
    private final ReactiveYoutubeApi reactiveYoutubeApi;

    @Value("${humming.youtube.player.url}")
    private String youtubeUrl;

    public Mono<RecommendResult> recommend(double latitude, double longitude) {

        return weatherService.getCurrentWeather(latitude, longitude)
            .flatMap(weather -> {
                String searchKeyword = searchKeywordProvider.provide(weather.getWeatherStatus());

                return reactiveYoutubeApi.getSearchYoutube(searchKeyword).map(youtube ->
                    new RecommendResult(
                        weather.getWeatherStatus(),
                        weather.getDescription(),
                        youtubeUrl,
                        youtube.getItems().stream().map(item -> item.getId()).collect(Collectors.toList())
                    )
                );
            });
    }
}
