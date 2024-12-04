package by.plus.priorbank.api;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class LoginApi {
    private final String POST_REQUEST_URL = "https://plus.priorbank.by/authorization/login.json";

    public ValidatableResponse getResponseForRequestWithData(String name, String height, String weight, String gender) {
        ValidatableResponse response = given()
                .formParam("name", name)
                .formParam("height", height)
                .formParam("weight", weight)
                .formParam("gender", gender)
                .when()
                .post(POST_REQUEST_URL)
                .then();
        return response;
    }
}
