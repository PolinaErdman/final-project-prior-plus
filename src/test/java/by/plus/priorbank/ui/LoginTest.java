package by.plus.priorbank.ui;

import by.plus.priorbank.ui.pages.LoginMessages;
import by.plus.priorbank.ui.pages.LoginPage;
import by.plus.priorbank.ui.steps.LoginStep;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Все поля пустые")
    public void emptyFieldsTest() {
        String EMPTY_VALUE = "";
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(EMPTY_VALUE, EMPTY_VALUE);
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }

    @Test
    @DisplayName("Неверные данные")
    public void incorrectDataTest() {
        Faker faker = new Faker();
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(faker.internet().emailAddress(), faker.internet().password());
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.AUTHORIZATION_ERROR, loginPage.getErrorMessage(), "Не совпадает ошибка!");
    }

    @Test
    @DisplayName("Пустое поле email")
    public void emptyEmailTest() {
        String EMPTY_VALUE = "";
        Faker faker = new Faker();
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(EMPTY_VALUE, faker.internet().password());
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(EMPTY_VALUE, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }

    @Test
    @DisplayName("Пустое поле password")
    public void emptyPasswordTest() {
        String EMPTY_VALUE = "";
        Faker faker = new Faker();
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(faker.internet().emailAddress(), EMPTY_VALUE);
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(EMPTY_VALUE, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }
}
