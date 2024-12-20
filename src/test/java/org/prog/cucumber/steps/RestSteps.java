package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.prog.selenium.dto.PhoneDtoResults;
import org.prog.selenium.dto.ResultsDto;

public class RestSteps {

    @SneakyThrows
    @Given("I request {int} random phones from allo.ua website")
    public void requestRandomPhones(int amount) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "iphone,id");
        requestSpecification.baseUri("https://allo.ua/");
        Response response = requestSpecification.get("/search");


        ValidatableResponse validatableResponse = response.then();
        SQLSteps.RANDOM_PHONES.addAll(response.as(PhoneDtoResults.class).getResults());
    }
}