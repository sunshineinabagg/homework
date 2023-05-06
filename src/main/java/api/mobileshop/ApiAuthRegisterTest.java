package api.mobileshop;

import api.mobileshop.ext.ApiTestExtension;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/user")
public class ApiAuthRegisterTest {

    @Test
    void registerTest() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();

        given()
                .body("{\n" +
                        "  \"address\": \"russia\",\n" +
                        "  \"email\": \"sdgrdsg@vas.ru\",\n" +
                        "  \"password\": \"vasya\",\n" +
                        "  \"phone\": \"8999999999\",\n" +
                        "  \"username\": \"" + userName + "\"\n" +
                        "}")
                .post("/api/auth/register")
                .then()
                .statusCode(201)
                .body("address", equalTo("russia"))
                .body("email", equalTo("sdgrdsg@vas.ru"))
                .body("phone", equalTo("8999999999"))
                .body("username", equalTo(userName));

    }
}
