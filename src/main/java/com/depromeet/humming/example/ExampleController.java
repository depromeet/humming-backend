package com.depromeet.humming.example;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/examples")
public class ExampleController {

    @ApiOperation(
        value = "API 설명",
        notes = "## 문서 제목 \n" +
                "--- \n" +
                "### 문서 작은 제목 \n" +
                "문서 내용"
    )
    @PostMapping
    public Mono<Example> example(@RequestBody Example example) {
        return Mono.just(example);
    }

    @AllArgsConstructor
    @Getter
    private static class Example {
        private String name;
        private int age;
    }
}
