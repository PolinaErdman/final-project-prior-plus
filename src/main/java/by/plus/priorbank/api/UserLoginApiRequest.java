package by.plus.priorbank.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLoginApiRequest extends BaseApi{
    public static RequestSpecification requestSpecification;

    public static void initRequestSpecification() {
        Response response = getStartPage();
        String sessionId = getSessionId(response);
        String csrf = getCSRF(response);
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://plus.priorbank.by")
                .setBasePath("/authorization/login.json")
                .setContentType("application/json;charset=UTF-8")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36")
                .addHeader("X-CSRF-Token", csrf)
                .addCookie("_session_id", sessionId)
                .build();
    }

    public static String getBody(String email, String password) {
        return "{\n" +
                "\"user\":\n" +
                "   {\n" +
                "      \"email\": \"" + email + "\",\n" +
                "      \"password\": \"" + password + "\"\n" +
                "   }\n" +
                "}";
    }
}
