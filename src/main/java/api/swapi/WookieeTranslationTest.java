package api.swapi;

        import api.swapi.ext.SwapiTestExtension;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;

        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SwapiTestExtension.class)
public class WookieeTranslationTest {

    @Test
    void translationTest() {
        given()
                .get("planets/1/?format=wookiee")
                .then()
                .statusCode(200)
                .body("whrascwo", equalTo("Traaoooooahwhwo"));
    }
}
