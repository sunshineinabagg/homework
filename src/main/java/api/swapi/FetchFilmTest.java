package api.swapi;

import api.mobileshop.ext.ApiTestExtension;
import api.swapi.ext.SwapiTestExtension;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SwapiTestExtension.class)
public class FetchFilmTest {

    @Test
    void fetchNewHopeTest() {
        given()
                .get("films/1/")
                .then()
                .statusCode(200)
                .body("title", equalTo("A New Hope"));
    }
}
