package by.plus.priorbank.ui;

import by.plus.priorbank.ui.pages.login.LoginMessages;
import by.plus.priorbank.ui.pages.login.LoginPage;
import by.plus.priorbank.ui.steps.LoginStep;
import by.plus.priorbank.utils.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Авторизация c пустым email и password")
    public void emptyFieldsTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(User.EMPTY_VALUE, User.EMPTY_VALUE);
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }

    @Test
    @DisplayName("Авторизация c невалидными данными")
    public void invalidDataTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(User.getEmail(), User.getPassword());
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.AUTHORIZATION_ERROR, loginPage.getErrorMessage(), "Не совпадает ошибка!");
    }

    @Test
    @DisplayName("Авторизация c пустым email")
    public void emptyEmailTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(User.EMPTY_VALUE, User.getPassword());
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(User.EMPTY_VALUE, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }

    @Test
    @DisplayName("Авторизация c пустым password")
    public void emptyPasswordTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(User.getEmail(), User.EMPTY_VALUE);
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(User.EMPTY_VALUE, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }
}
