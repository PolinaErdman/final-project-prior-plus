package by.plus.priorbank.ui;

import by.plus.priorbank.ui.pages.LoginMessages;
import by.plus.priorbank.ui.pages.LoginPage;
import by.plus.priorbank.ui.steps.LoginStep;
import by.plus.priorbank.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("Все поля пустые")
    public void emptyFieldsTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(Utils.EMPTY_VALUE, Utils.EMPTY_VALUE);
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }

    @Test
    @DisplayName("Невалидные данные")
    public void invalidDataTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(Utils.getEmail(), Utils.getPassword());
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.AUTHORIZATION_ERROR, loginPage.getErrorMessage(), "Не совпадает ошибка!");
    }

    @Test
    @DisplayName("Пустое поле email")
    public void emptyEmailTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(Utils.EMPTY_VALUE, Utils.getPassword());
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(Utils.EMPTY_VALUE, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }

    @Test
    @DisplayName("Пустое поле password")
    public void emptyPasswordTest() {
        LoginStep loginStep = new LoginStep();
        loginStep.fillFormAndSubmit(Utils.getEmail(), Utils.EMPTY_VALUE);
        LoginPage loginPage = new LoginPage();
        Assertions.assertEquals(Utils.EMPTY_VALUE, loginPage.getEmailErrorMessage(), "Не совпадает ошибка email поля!");
        Assertions.assertEquals(LoginMessages.NO_DATA, loginPage.getPasswordErrorMessage(), "Не совпадает ошибка password поля!");
    }
}
