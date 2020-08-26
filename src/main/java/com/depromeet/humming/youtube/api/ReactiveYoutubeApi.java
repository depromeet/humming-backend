package com.depromeet.humming.youtube.api;

import com.depromeet.humming.youtube.model.Youtube;
import reactor.core.publisher.Mono;

public interface ReactiveYoutubeApi {

  Mono<Youtube> getSearchYoutube(String search);
}