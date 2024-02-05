package com.jefflife.gameserver.look.integrate;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LookSystemTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @DisplayName("봐 => 내가 서 있는 장소를 보여준다")
    @Test
    @Sql(scripts = "classpath:LookSystemTest-setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:LookSystemTest-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testJustSee() {
        // given
        String playerId = "1";
        String action = "봐";

        // when
        given()
            .header("Content-Type", "application/json")
            .queryParam("playerId", playerId)
            .queryParam("action", action)
        .when()
            .get("/look")
        .then()
            .statusCode(200)
            .body("payload.id", equalTo(1))
            .body("payload.summary", equalTo("테스트 중앙"))
            .body("payload.description", equalTo("흰 빛으로 가득한 공간입니다."));
    }

    @DisplayName("돌멩이 봐 => 내가 서 있는 장소의 돌멩이를 보여준다")
    @Test
    @Sql(scripts = "classpath:LookSystemTest-setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:LookSystemTest-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testSeeTheItemOnTheFloor() {
        // given
        String playerId = "1";
        String target = "돌멩이";
        String action = "봐";

        // when
        given()
            .header("Content-Type", "application/json")
            .queryParam("playerId", playerId)
            .queryParam("target", target)
            .queryParam("action", action)
        .when()
            .get("/look")
        .then()
            .statusCode(200)
            .body("payload.id", equalTo(1))
            .body("payload.name", equalTo(target))
            .body("payload.description", equalTo("주먹만하고 흙이 묻어 있는 돌멩이이다."));
    }

    @DisplayName("손전등 봐 => 내 가방안의 손전등을 보여준다")
    @Test
    @Sql(scripts = "classpath:LookSystemTest-setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:LookSystemTest-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testSeeTheItemInTheBag() {
        // given
        String playerId = "1";
        String target = "손전등";
        String action = "봐";

        // when
        given()
            .header("Content-Type", "application/json")
            .queryParam("playerId", playerId)
            .queryParam("target", target)
            .queryParam("action", action)
        .when()
                .get("/look")
        .then()
            .statusCode(200)
            .body("payload.id", equalTo(2))
            .body("payload.name", equalTo(target))
            .body("payload.description", equalTo("검은색 메탈 재질의 손잡이가 있는 LCD 손전등이다."));
    }
}
