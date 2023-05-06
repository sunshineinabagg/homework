package api.swapi;

        import api.swapi.ext.SwapiTestExtension;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;

        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SwapiTestExtension.class)
public class FetchSpecieTest {

    @Test
    void fetchDroidTest() {
        given()
                .get("species/2/")
                .then()
                .statusCode(200)
                .body("name", equalTo("Droid"));
    }
}
