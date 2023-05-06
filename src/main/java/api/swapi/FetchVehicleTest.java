package api.swapi;

import api.swapi.ext.SwapiTestExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SwapiTestExtension.class)
public class FetchVehicleTest {

    @Test
    void fetchSandCrawlerTest() {
        given()
                .get("vehicles/4")
                .then()
                .statusCode(200)
                .body("name", equalTo("Sand Crawler"));
    }
}
