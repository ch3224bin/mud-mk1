package com.jefflife.frontapiserver.adapter.out.template;

import com.jefflife.common.model.RoomCommonModel;
import com.jefflife.frontapiserver.application.domain.model.HtmlResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MustacheHtmlCompilerTest {

    @Autowired
    MustacheHtmlCompiler mustacheHtmlCompiler;

    @Test
    void name() {
        // given
        RoomCommonModel room = new RoomCommonModel(1L, "test", "test", Collections.emptyList(), "출구", 1L);

        // when
        Mono<HtmlResult> resultMono = mustacheHtmlCompiler.compile("RoomModel", room);

        // then
        StepVerifier.create(resultMono)
                .expectNextMatches(result -> {
                    System.out.println(result.getHtml());
                    return true;
                })
                .verifyComplete();
    }
}