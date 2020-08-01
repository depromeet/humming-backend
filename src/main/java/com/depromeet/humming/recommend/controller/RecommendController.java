package com.depromeet.humming.recommend.controller;

import com.depromeet.humming.recommend.model.RecommendResult;
import com.depromeet.humming.weather.model.WeatherStatus;
import com.depromeet.humming.youtube.model.Id;
import com.google.common.collect.ImmutableList;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recommend-musics")
public class RecommendController {

    @ApiOperation(value = "위치 기반으로 음악을 추천해주는 API")
    @GetMapping
    public Mono<RecommendResult> recommend(
        @ApiParam("위도") @RequestParam("latitude") double latitude,
        @ApiParam("경도")  @RequestParam("longitude") double longitude
    ) {
        return Mono.just(
            new RecommendResult(
                WeatherStatus.CLOUD,
                "Many Cloud",
                "http://www.youtube.com/embed",
                ImmutableList.of(
                    new Id("kind", "videoId", "channelId", "playListId"),
                    new Id("kind", "videoId", "channelId", "playListId"),
                    new Id("kind", "videoId", "channelId", "playListId")
                )
            )
        );
    }
}
