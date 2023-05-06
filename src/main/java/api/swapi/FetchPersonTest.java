package api.swapi;

import api.mobileshop.ext.ApiTestExtension;
import api.swapi.ext.SwapiTestExtension;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SwapiTestExtension.class)
public class FetchPersonTest {

    @Test
    void fetchDarthVaderTest() {
        given()
                .get("people/4/")
                .then()
                .statusCode(200)
                .body("name", equalTo("Darth Vader"));
    }
}
