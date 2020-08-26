package com.depromeet.humming.youtube.api;

import com.depromeet.humming.youtube.model.Youtube;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class YoutubeApi implements ReactiveYoutubeApi {

  private final String youtubeApiUrl;
  private final String youtubeApiKey;
  private final WebClient webClient;

  public YoutubeApi(
    @Value("${humming.youtube.api.url}") String apiUrl,
    @Value("${humming.youtube.api.key}") String apiKey, WebClient webClient
  ) {
    this.youtubeApiUrl = apiUrl
        + "/youtube/v3/search?key={key}&part=snippet&type=video&maxResults=20&videoEmbeddable=true&q={search}";
    this.youtubeApiKey = apiKey;
    this.webClient = webClient;
  }

  @Override
  public Mono<Youtube> getSearchYoutube(String search) {
    return webClient.get().uri(youtubeApiUrl, youtubeApiKey, search).retrieve().bodyToMono(Youtube.class);
  }
}
