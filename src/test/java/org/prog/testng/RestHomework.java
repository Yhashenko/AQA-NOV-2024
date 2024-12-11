package org.prog.testng;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

// TODO: write simple test that will:
// TODO: - include location to query params
// TODO: - assert location.city != null
// TODO: - print timezone.description
public class RestHomework {
    @Test
    public void myRestTest() {
        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.queryParam("inc", "gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api/");

        Response response = requestSpecification.get();
        response.prettyPrint();

        response.then().statusCode(200);
        response.then().contentType("application/json");

        JsonPath jsonPath = response.jsonPath();

        String city = jsonPath.getString("results[0].location.city");
        String timezoneDescription = jsonPath.getString("results[0].location.timezone.description");

        Assertions.assertNotNull(city, "City should not be null");
        
        System.out.println("Timezone Description: " + timezoneDescription);

    }
}

