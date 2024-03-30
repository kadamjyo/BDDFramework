package org.R3.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class basicValidationStepDef {
    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int responseCode;
    private static final String BASE_URL = "https://open.er-api.com/v6/latest";

    @Given("I hit the url of get USD endpoint")
    public void iAmAnAuthorizedUser() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("I send {} request")
    public void sendRequest(String valid){
        httpRequest = RestAssured.given();
        response = httpRequest.get(valid);
    }

    @Then("I validate response has {} code")
    public void receiveResponse(int code){
        statusCode = response.getStatusCode();
        assertEquals(code,statusCode);
    }

    @Then("I validate the rest of {} against USD is in range {} and {}")
    public void iValidateTheRestOfAgainstUSDIs(String currency, float minRate, float maxRate) {
        JsonPath jsonPath = response.jsonPath();
        float rate = jsonPath.getJsonObject("rates["+currency+"]");
        assertTrue(rate>=minRate && rate <=maxRate );

    }

    @Then("I validate the status {}")
    public void iValidateTheStatus(String status) {
        JsonPath jsonPath = response.jsonPath();
        String result = jsonPath.getJsonObject("result");
        assertEquals(result, status);

    }

    @Then("I validate response time is less than {}")
    public void iValidateResponseTimeIsLessThan(String timeVerify) {
        JsonPath jsonPath = response.jsonPath();
        int timeStamp = jsonPath.getJsonObject("time_last_update_unix");
        Date date = new Date();
        long diff = (date.getTime() / 1000L) - timeStamp;
        assertTrue(diff>=3000L);
    }
}

