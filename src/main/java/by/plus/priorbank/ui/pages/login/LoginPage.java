package by.plus.priorbank.ui.pages.login;

import by.plus.priorbank.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public LoginPage() {
        driver = Driver.getDriver();
    }

    public void fillEmail(String email) {
        driver.findElement(By.xpath(LoginXpath.INPUT_EMAIL_XPATH)).sendKeys(email);
        logger.info(String.format("Заполнили поле login = '%s'", email));
    }

    public void fillPassword(String password) {
        driver.findElement(By.xpath(LoginXpath.INPUT_PASSWORD_XPATH)).sendKeys(password);
        logger.info(String.format("Заполнили поле password = '%s'", password));
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath(LoginXpath.BUTTON_LOGIN_XPATH)).click();
        logger.info("Кликнули на кнопку 'Залогиниться'");
    }

    public String getEmailErrorMessage() {
        String errorMessage = driver.findElement(By.xpath(LoginXpath.EMAIL_ERROR_MESSAGE_XPATH)).getText();
        logger.info(String.format("Получили ошибку поля email = '%s'", errorMessage));
        return errorMessage;
    }

    public String getPasswordErrorMessage() {
        String errorMessage =  driver.findElement(By.xpath(LoginXpath.PASSWORD_ERROR_MESSAGE_XPATH)).getText();
        logger.info(String.format("Получили ошибку поля password = '%s'", errorMessage));
        return errorMessage;
    }

    public String getErrorMessage() {
        String errorMessage =  driver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_XPATH)).getText();
        logger.info(String.format("Получили ошибку = '%s'", errorMessage));
        return errorMessage;
    }

    public void clickCatalogueButton() {
        WebElement catalogueButton = driver.findElement(By.xpath(LoginXpath.BUTTON_OPEN_CATALOGUE_XPATH));
        new Actions(driver).scrollToElement(catalogueButton).perform();
        catalogueButton.click();
        logger.info("Кликнули на кнопку 'Открыть каталог'");
    }
}
