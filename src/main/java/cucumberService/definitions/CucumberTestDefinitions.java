package cucumberService.definitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import testBase.TestBase;
import utils.FileHelper;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CucumberTestDefinitions extends TestBase {


    private Response response;

    @When("GET request is made to {word} endpoint with {word} {word} parameter")
    public void doAGetCallToEndpointWithParameter(String httpPath, String queryParameterNames, String queryParameterValue) {
        response = given()
                .queryParam(queryParameterNames, queryParameterValue)
                .when()
                .get(httpPath);
    }

    @Then("the request status {int} is returned")
    public void assertResponseCode(int responseCode) {
        assertThat(response.getStatusCode()).isEqualTo(responseCode);
    }

    @And("the list of elements with {word} {word} is displayed")
    public void assertThatBodyContainsAskedElements(String queryParameterNames, String queryParameterValue) {
        List<String> statusList = response.jsonPath().getList(queryParameterNames);
        for (String status : statusList) {
            assertThat(status).isEqualTo(queryParameterValue);
        }
    }

    @When("POST request is made to {word} endpoint with the body {word}")
    public void doAPostRequestToEndpointWithBody(String httpPath, String body) {
        response = given()
                .body(FileHelper.reader(body))
                .when()
                .post(httpPath);
    }

    @And("the body is as is {word}")
    public void assertThatBodyIsAsProvided(String responseBody) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        assertThat(mapper.readTree(response.getBody().asPrettyString())).isEqualTo(mapper.readTree(FileHelper.reader(responseBody)));
    }

    @When("PUT request is made to {word} endpoint with the body {word}")
    public void doAPutRequestToEndpointWithBody(String httpPath, String body) {
        response = given()
                .body(FileHelper.reader(body))
                .when()
                .put(httpPath);
    }

    @And("field {word} has value {word}")
    public void assertThatFieldInBodyContainsProvidedValue(String parameterName, String parameterValue) {
        assertThat(response.jsonPath().getString(parameterName)).isEqualTo(parameterValue);
    }

    @When("DELETE request to {word} is made")
    public void doADeleteRequest(String httpPath) {
        response = given()
                .when()
                .delete(httpPath);
    }

    @And("GET request to {word} returns code {int}")
    public void assertThatRequestReturnsProperCode(String httpRequest, int responseCode) {
        given()
                .when()
                .get(httpRequest)
                .then()
                .statusCode(responseCode);
    }

}
