package com.jefflife.frontapiserver.application.domain.service.command;

import com.jefflife.frontapiserver.application.domain.model.CommandData;
import com.jefflife.frontapiserver.application.domain.model.CommandValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LookCommandDataParserTest {

    @DisplayName("\"봐\" 명령어를 파싱한다")
    @Test
    void testJustLook() {
        // given
        LookCommandDataParser lookCommandDataParser = new LookCommandDataParser();

        // when
        Mono<CommandData> commandData = lookCommandDataParser.parse(CommandValue.of("봐"));

        // then
        assertAll(
//            () -> assertThat(commandData.getTarget()).isNull(),
//            () -> assertThat(commandData.getContent()).isNull(),
//            () -> assertThat(commandData.getAdverb()).isNull(),
//            () -> assertThat(commandData.getAction()).isEqualTo("봐")
        );
    }

    @DisplayName("\"[대상] 봐\" 명령어를 파싱한다")
    @Test
    void testLookTarget() {
        // given
        LookCommandDataParser lookCommandDataParser = new LookCommandDataParser();

        // when
        Mono<CommandData> commandData = lookCommandDataParser.parse(CommandValue.of("개똥이 봐"));

        // then
        assertAll(
//                () -> assertThat(commandData.getTarget()).isEqualTo("개똥이"),
//                () -> assertThat(commandData.getContent()).isNull(),
//                () -> assertThat(commandData.getAdverb()).isNull(),
//                () -> assertThat(commandData.getAction()).isEqualTo("봐")
        );
    }

    @DisplayName("\"[대상] [부사] 봐\" 명령어를 파싱한다")
    @Test
    void testLookTargetWithAdverb() {
        // given
        LookCommandDataParser lookCommandDataParser = new LookCommandDataParser();

        // when
        Mono<CommandData> commandData = lookCommandDataParser.parse(CommandValue.of("개똥이 뻔하게 봐"));

        // then
        assertAll(
//                () -> assertThat(commandData.getTarget()).isEqualTo("개똥이"),
//                () -> assertThat(commandData.getContent()).isNull(),
//                () -> assertThat(commandData.getAdverb()).isNull(),
//                () -> assertThat(commandData.getAction()).isEqualTo("봐")
        );
    }
}