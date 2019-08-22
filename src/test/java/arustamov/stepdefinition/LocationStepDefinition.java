package arustamov.stepdefinition;

import arustamov.entity.Location;
import arustamov.step.LocationStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;
import org.apache.http.HttpStatus;

public class LocationStepDefinition {

    @Shared
    private LocationStep locationStep;


    @Given("the application is running")
    public void the_application_is_running() {
        SerenityRest.setDefaultBasePath("/location");
    }

    @When("I get all locations")
    public void i_get_all_locations() {
        locationStep.getAll();
    }

    @When("I get the {string} location")
    public void i_get_the_location(String code) {
        locationStep.getLocation(code);
    }

    @When("I post the {string} location")
    public void i_post_the_location(String code) {
        locationStep.post(
            new Location(
                "1842347-1560779940",
                "£829.99",
                code)
        );
    }

    @Then("I should see {string} location in the response")
    public void i_should_see_location_in_the_response(String code) {
        locationStep.verifyResponseHasLocation(code);
    }

    @Then("I should see response schema is correct")
    public void i_should_see_response_schema_is_correct() {
        locationStep.verifyResponseSchema();
    }

    @Then("I should see server error")
    public void i_should_see_server_error() {
        locationStep.verifyResponseStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
}
