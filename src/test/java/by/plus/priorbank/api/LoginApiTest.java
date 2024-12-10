package by.plus.priorbank.api;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest {
    @BeforeEach
    void setUp() {
        by.plus.priorbank.api.UserLoginApiRequest.initRequestSpecification();
    }

    @Test
    @DisplayName("Авторизация c невалидным логином")
    public void authorizationWithInvalidLoginTest() {
        Faker faker = new Faker();
        String login = faker.internet().emailAddress();
        String password = faker.internet().password();

        given()
                .spec(by.plus.priorbank.api.UserLoginApiRequest.requestSpecification)
                .body(by.plus.priorbank.api.UserLoginApiRequest.getBody(login, password))
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
        String EMPTY_VALUE = "";
        String login = EMPTY_VALUE;
        String password = EMPTY_VALUE;

        given()
                .spec(by.plus.priorbank.api.UserLoginApiRequest.requestSpecification)
                .body(by.plus.priorbank.api.UserLoginApiRequest.getBody(login, password))
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
        String EMPTY_VALUE = "";
        Faker faker = new Faker();
        String login = EMPTY_VALUE;
        String password = faker.internet().password();

        given()
                .spec(by.plus.priorbank.api.UserLoginApiRequest.requestSpecification)
                .body(by.plus.priorbank.api.UserLoginApiRequest.getBody(login, password))
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
        String EMPTY_VALUE = "";
        Faker faker = new Faker();
        String login = faker.internet().emailAddress();
        String password = EMPTY_VALUE;

        given()
                .spec(by.plus.priorbank.api.UserLoginApiRequest.requestSpecification)
                .body(by.plus.priorbank.api.UserLoginApiRequest.getBody(login, password))
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(422)
                .body("errors.password[0]", equalTo(UserLoginApiResponse.EMPTY_LOGIN_OR_PASSWORD_MESSAGE));
    }
}
