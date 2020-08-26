package com.depromeet.humming.recommend.controller;

import com.depromeet.humming.recommend.model.RecommendResult;
import com.depromeet.humming.recommend.service.MusicRecommendService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recommend-musics")
@RequiredArgsConstructor
public class RecommendController {

    private final MusicRecommendService musicRecommendService;

    @ApiOperation(value = "위치 기반으로 음악을 추천해주는 API")
    @GetMapping
    public Mono<RecommendResult> recommend(
        @ApiParam("위도") @RequestParam("latitude") double latitude,
        @ApiParam("경도")  @RequestParam("longitude") double longitude
    ) {
        return musicRecommendService.recommend(latitude, longitude);
    }
}
