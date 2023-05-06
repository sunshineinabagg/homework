package api;

import api.ext.ApiTestExtension;
import com.github.javafaker.Faker;
import io.restassured.http.Header;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/user")
public class ApiAuthLoginTest {

    String token;
    String userName;

    @BeforeEach
    void setUp() {
        userName = new Faker().name().fullName();
        token = given()
                .body("{\n" +
                        "  \"address\": \"russia\",\n" +
                        "  \"email\": \"sdgrdsg@vas.ru\",\n" +
                        "  \"password\": \"vasya\",\n" +
                        "  \"phone\": \"8999999999\",\n" +
                        "  \"username\": \"" + userName + "\"\n" +
                        "}")
                .post("/api/auth/register")
                .then()
                .extract()
                .jsonPath()
                .getString("token");
    }

    @Test
    void successfulGetUserTest() {
        given()
                .header(new Header("Authorization", "Bearer " + token))
                .body("{\n" +
                        "  \"password\": \"vasya\",\n" +
                        "  \"username\": \""+ userName + "\"\n" +
                        "}")
                .post("/api/auth/login")
                .then()
                .statusCode(200)
                .body("username", equalTo(userName));

    }
}
