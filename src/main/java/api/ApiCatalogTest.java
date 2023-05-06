package api;

import api.ext.ApiTestExtension;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;

@ExtendWith(ApiTestExtension.class)
@DisplayName("/api/catalog")
public class ApiCatalogTest {

    @Test
    void getCatalogTest() {
        given()
                .get("/api/catalog")
                .then()
                .statusCode(200)
                .body("info.name", Matchers.hasItems("Apple iPhone X",
                        "Apple iPhone 8 Plus", "Samsung Galaxy S8"));
    }
}
