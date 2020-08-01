package com.depromeet.humming.weather.api;

import com.depromeet.humming.weather.model.Weather;
import com.depromeet.humming.weather.model.WeatherApiResponse;
import com.depromeet.humming.weather.service.WeatherStatusProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class OpenWeatherApi implements ReactiveWeatherApi {

    private final WeatherStatusProvider weatherStatusProvider;
    private final String currentWeatherUrl;
    private final String apiKey;
    private final WebClient webClient;

    public OpenWeatherApi(
        @Value("${humming.weather.api.url}") String apiUrl,
        @Value("${humming.weather.api.key}") String apiKey,
        WebClient webClient,
        WeatherStatusProvider weatherStatusProvider
    ) {
        this.currentWeatherUrl = apiUrl + "/data/2.5/forecast?lat={lat}&lon={lon}&appid={appId}";
        this.apiKey = apiKey;
        this.webClient = webClient;
        this.weatherStatusProvider = weatherStatusProvider;
    }

    @Override
    public Mono<Weather> getCurrentWeather(double latitude, double longitude) {

        return webClient.get()
                .uri(currentWeatherUrl, latitude, longitude, apiKey)
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .map(res -> {
                    WeatherApiResponse.WeatherInfo data = res.getList().get(0).getWeather().get(0);
                    return new Weather(weatherStatusProvider.provide(data.getType()), data.getDescription());
                });
    }
}
