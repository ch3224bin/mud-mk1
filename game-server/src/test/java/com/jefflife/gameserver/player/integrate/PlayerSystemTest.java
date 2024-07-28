package com.jefflife.gameserver.player.integrate;

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
public class PlayerSystemTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @DisplayName("동 => 플레이어를 동쪽으로 이동시킨다")
    @Test
    @Sql(scripts = "classpath:LookSystemTest-setup.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:LookSystemTest-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testMovePlayer() {
        // given
        String playerId = "1";
        String direction = "EAST";

        // when
        given()
            .header("Content-Type", "application/json")
            .body("{\"direction\": \"" + direction + "\"}")
            .pathParam("id", playerId)
        .when()
            .patch("/api/v1/players/{id}/move")
        .then()
            .statusCode(200)
            .body("roomId", equalTo(2));
    }
}
