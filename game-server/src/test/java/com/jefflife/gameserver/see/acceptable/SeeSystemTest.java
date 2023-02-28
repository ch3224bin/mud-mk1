package com.jefflife.gameserver.see.acceptable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeeSystemTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("봐 => 내가 서 있는 장소를 보여준다")
    @Test
    @Sql("classpath:SeeSystemTest.sql")
    void testJustSee() {
        // given
        String playerId = "1";

        // when
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        HttpEntity<Void> request = new HttpEntity<>(null, headers);

        ResponseEntity<Object> response = restTemplate.exchange(
                "/see?playerId={playerId}",
                HttpMethod.GET,
                request,
                Object.class,
                playerId
        );

        // then
        then(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        // 보여줄 오브젝트들을 메세지큐로 전송한다
        // 메세지큐는 Mocking 되어야 테스트 가능
        // 현재는 테스트하기 어렵다
    }
}
