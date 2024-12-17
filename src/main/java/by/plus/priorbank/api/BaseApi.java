package by.plus.priorbank.api;

import io.restassured.response.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class BaseApi {

    public static Response getStartPage() {
        return given()
                .baseUri("https://plus.priorbank.by")
                .get();
    }

    public static String getSessionId(Response response) {
        return response.cookie("_session_id");
    }

    public static String getCSRF(Response response) {
        String body = response.getBody().asString();
        Matcher matcher = Pattern.compile("(?<=name=\\\"csrf-token\\\" content=\\\").*(?=\\\")").matcher(body);
        matcher.find();
        return matcher.group();
    }
}
