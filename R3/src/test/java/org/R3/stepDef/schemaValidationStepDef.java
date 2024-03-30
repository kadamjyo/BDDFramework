package org.R3.stepDef;

import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class schemaValidationStepDef {
    public int statusCode;
    public RequestSpecification httpRequest;
    public Response response;
    public int responseCode;
    public ResponseBody body;
    private static final String BASE_URL = "https://open.er-api.com/v6/latest";

    @Then("I validate response against JSON schema")
    public void iValidateResponseAgainstJSONSchema() {
        File file = new File("src/test/resources/generatedSchema.json");
        httpRequest = RestAssured.given();
        response = httpRequest.get();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));

    }

    @Then("I validate {} currency pairs are returned")
    public void iValidateCurrencyPairsAreReturned(String size) {
        httpRequest = RestAssured.given();
        response = httpRequest.get();
        JsonPath jsonPath = response.jsonPath();
        assertEquals(jsonPath.get("rates.size()").toString(),size);
    }
}
