package com.depromeet.humming.youtube.api;

import com.depromeet.humming.youtube.model.Youtube;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class YoutubeApi implements ReactiveYoutubeApi {

    private static final String API_URL = "https://www.googleapis.com/youtube/v3/search" +
            "?key=AIzaSyBRa6UEjmyCOrv5ug1jEB8DOs2NuKZFePk&part=snippet&type=video&maxResults=20&videoEmbeddable=true&q={}";

    private final WebClient webClient;

    public YoutubeApi(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Youtube> getSearchYoutube(String search) {

        return webClient.get().uri(API_URL, search)
                .retrieve()
                .bodyToMono(Youtube.class);
    }
}
