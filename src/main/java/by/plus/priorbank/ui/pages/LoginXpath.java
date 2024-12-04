package by.plus.priorbank.ui.pages;

public class LoginXpath {
    public static final String INPUT_EMAIL_XPATH = "//input[@name='user[email]']";
    public static final String INPUT_PASSWORD_XPATH = "//input[@name='user[password]']";
    public static final String BUTTON_LOGIN_XPATH = "//button[@type='submit']";
    public static final String EMAIL_ERROR_MESSAGE_XPATH = "//div[@class='mb-3' and descendant::input[@name='user[email]']]/span[@class='error-message']";
    public static final String PASSWORD_ERROR_MESSAGE_XPATH = "//div[@class='mb-3' and descendant::input[@name='user[password]']]/span[@class='error-message']";
    public static final String ERROR_MESSAGE_XPATH = "//div[@class='vl-notification-message danger']";
    public static final String BUTTON_OPEN_CATALOGUE_XPATH = "//div[@class='categories__button-wrapper']/button";
}
