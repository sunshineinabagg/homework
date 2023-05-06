package api.mobileshop;

import api.mobileshop.ext.ApiTestExtension;
import com.github.javafaker.Faker;
import io.restassured.http.Header;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/cart")
public class ApiCartAddPhoneTest {

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
    void addPhoneTest() {
        given()
                .header(new Header("Authorization", "Bearer " + token))
                .body("{\n" +
                        "  \"product\": \"61b35d36dccbe752b78a2a8d\",\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"user\": \"61b3677584790d001212a841\"\n" +
                        "}")
                .post("api/cart")
                .then()
                .statusCode(200);
    }
}
