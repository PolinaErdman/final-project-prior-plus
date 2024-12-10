package by.plus.priorbank.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserLoginApiRequest {
    public static RequestSpecification requestSpecification;

    public static void initRequestSpecification() {
        String sessionId = getSessionId();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://plus.priorbank.by")
                .setBasePath("/authorization/login.json")
                .setContentType("application/json;charset=UTF-8")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/130.0.0.0 Safari/537.36")
                //.addHeader("X-CSRF-Token", "6kz3tAhnAUN39FVcLrHYQKP1sHmaY3vDHm+oLKMe5GdoB0DbbPsfNhru2mO+I7IF0gLmbOaRgpkxq6OTQN4qng==")
                //.addCookie("_session_id", "VgcdTcRNU4l7m2BI8aDPYNE3EitTVCah4L6Bj81M%2BYgYX7qMN49aMB5QTC%2BaVqWCvG4fl40C9Csr%2F1HHe4VirRKg211pHG6Ieb%2BDiyMnRl2hpGUNJ2K5numvtoRG0ujFPjR6wdStx1waJv7PY6yQTG4R%2FaBElJxkqptOTnfdr8WrrYIVXGLJoBXXk1oQ22PSoAG13iJPPDKRjvCzjGAor1b86FqeumdCZHD5kTiZMQhYIxqHyh4JwYDTAWWR9UWC5BTcaINOhpiflmm7hWR80G5GLHxbQY8Rd3i9nzl6hqh0eq%2BcGJmePOc2v63sYs7XtVFmzHgqH6Rhq2cZTkY%2Bp--zvBjLqnOikCJwWig--xHl17J4sxGqgDc1S5eAklA%3D%3D")
                //.addCookie("_session_id", sessionId)
                .build();
    }

    public static String getSessionId() {
        String sessionId = given()
                .baseUri("https://plus.priorbank.by")
                .get()
                .cookie("_session_id");
        return sessionId;
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
