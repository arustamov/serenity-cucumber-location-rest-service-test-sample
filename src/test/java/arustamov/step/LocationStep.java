package arustamov.step;

import arustamov.entity.Location;
import arustamov.ws.EndPoint;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;

public class LocationStep {

    @Step
    public void getAll() {
        SerenityRest
            .given()
            .basePath(EndPoint.GET_ALL_LOCATIONS.getUrl())
            .get();
    }

    @Step
    public void getLocation(final String code) {
        SerenityRest
            .given()
            .basePath(EndPoint.GET_LOCATION.getUrl())
            .pathParam("code", code)
            .get();
    }

    @Step
    public void post(final Location location) {
        SerenityRest
            .given()
            .contentType(ContentType.JSON)
            .basePath(EndPoint.POST_LOCATION.getUrl())
            .body(location)
            .when()
            .post();
    }

    @Step
    public void verifyResponseHasLocation(final String code) {
        SerenityRest
            .then()
            .body("code", Matchers.hasItem(code));
    }

    @Step
    public void verifyResponseSchema() {
        final Location location = SerenityRest
            .then()
            .extract()
            .body()
            .as(Location.class);
        Assertions.assertThat(location)
            .as("Verify response schema")
            .isNotNull();
    }

    @Step
    public void verifyResponseStatusCode(final Integer statusCode) {
        SerenityRest
            .then()
            .statusCode(statusCode);
    }
}
