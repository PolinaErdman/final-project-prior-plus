package by.plus.priorbank.api;

import by.plus.priorbank.utils.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest extends BaseTest{

    @Test
    @DisplayName("Авторизация c невалидными данными")
    public void authorizationWithInvalidLoginTest() {
        String login = User.getEmail();
        String password = User.getPassword();

        given()
                .spec(UserLoginApiRequest.requestSpecification)
                .body(UserLoginApiRequest.getBody(login, password))
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("errors.global[0]", equalTo(UserLoginApiResponse.INVALID_LOGIN_OR_PASSWORD_MESSAGE));
    }

    @Test
    @DisplayName("Авторизация c пустым email и password")
    public void authorizationWithEmptyEmailAndPasswordTest() {
        String login = User.EMPTY_VALUE;
        String password = User.EMPTY_VALUE;

        given()
                .spec(UserLoginApiRequest.requestSpecification)
                .body(UserLoginApiRequest.getBody(login, password))
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("errors.password[0]", equalTo(UserLoginApiResponse.EMPTY_LOGIN_OR_PASSWORD_MESSAGE))
                .body("errors.email[0]", equalTo(UserLoginApiResponse.EMPTY_LOGIN_OR_PASSWORD_MESSAGE))
                .body("errors.email[1]", equalTo(UserLoginApiResponse.INCORRECT_EMAIL_MESSAGE));
    }

    @Test
    @DisplayName("Авторизация c пустым email")
    public void authorizationWithEmptyEmailTest() {
        String login = User.EMPTY_VALUE;
        String password = User.getPassword();

        given()
                .spec(UserLoginApiRequest.requestSpecification)
                .body(UserLoginApiRequest.getBody(login, password))
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("errors.email[0]", equalTo(UserLoginApiResponse.EMPTY_LOGIN_OR_PASSWORD_MESSAGE))
                .body("errors.email[1]", equalTo(UserLoginApiResponse.INCORRECT_EMAIL_MESSAGE));
    }

    @Test
    @DisplayName("Авторизация c пустым password")
    public void authorizationWithEmptyPasswordTest() {
        String login = User.getEmail();
        String password = User.EMPTY_VALUE;

        given()
                .spec(UserLoginApiRequest.requestSpecification)
                .body(UserLoginApiRequest.getBody(login, password))
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("errors.password[0]", equalTo(UserLoginApiResponse.EMPTY_LOGIN_OR_PASSWORD_MESSAGE));
    }
}
