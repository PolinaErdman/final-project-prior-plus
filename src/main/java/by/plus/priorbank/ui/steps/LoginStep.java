package by.plus.priorbank.ui.steps;

import by.plus.priorbank.ui.pages.LoginPage;

public class LoginStep {
    public void fillFormAndSubmit(String email, String password) {
        LoginPage loginPage = new LoginPage();

        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
    }
}
