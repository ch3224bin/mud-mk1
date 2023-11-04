package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandData;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

class LookCommandDataParserTest {

    @DisplayName("\"봐\" 명령어를 파싱한다")
    @Test
    void testJustLook() {
        // given
        LookCommandDataParser lookCommandDataParser = new LookCommandDataParser();

        // when
        Mono<CommandData> commandData = lookCommandDataParser.parse(CommandValue.of("봐"));

        // then
        StepVerifier.create(commandData)
                .expectNextMatches(data -> {
                    assertThat(data.getTarget()).isNull();
                    assertThat(data.getContent()).isNull();
                    assertThat(data.getAdverb()).isNull();
                    assertThat(data.getAction()).isEqualTo("봐");
                    return true;
                })
                .verifyComplete();
    }

    @DisplayName("\"[대상] 봐\" 명령어를 파싱한다")
    @Test
    void testLookTarget() {
        // given
        LookCommandDataParser lookCommandDataParser = new LookCommandDataParser();

        // when
        Mono<CommandData> commandData = lookCommandDataParser.parse(CommandValue.of("개똥이 봐"));

        // then
        StepVerifier.create(commandData)
                .expectNextMatches(data -> {
                    assertThat(data.getTarget()).isEqualTo("개똥이");
                    assertThat(data.getContent()).isNull();
                    assertThat(data.getAdverb()).isNull();
                    assertThat(data.getAction()).isEqualTo("봐");
                    return true;
                })
                .verifyComplete();
    }

    @DisplayName("\"[대상] [부사] 봐\" 명령어를 파싱한다")
    @Test
    void testLookTargetWithAdverb() {
        // given
        LookCommandDataParser lookCommandDataParser = new LookCommandDataParser();

        // when
        Mono<CommandData> commandData = lookCommandDataParser.parse(CommandValue.of("개똥이 뻔하게 봐"));

        // then
        StepVerifier.create(commandData)
                .expectNextMatches(data -> {
                    assertThat(data.getTarget()).isEqualTo("개똥이");
                    assertThat(data.getContent()).isNull();
                    assertThat(data.getAdverb()).isNull();
                    assertThat(data.getAction()).isEqualTo("봐");
                    return true;
                })
                .verifyComplete();
    }
}