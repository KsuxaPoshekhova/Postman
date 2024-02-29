package ru.netology;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given ;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostmanEchoTest {

    @Test
    void postmanTest() {
        // Given - When - Then
        // Предусловия
        String text = "Hi, friend!";
        given()
                .baseUri("https://postman-echo.com")
                .body("Hi, friend!") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body( "data", org.hamcrest.Matchers.equalTo(text ) );
    }
}
