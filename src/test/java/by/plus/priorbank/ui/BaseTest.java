package by.plus.priorbank.ui;

import by.plus.priorbank.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    private static final Logger logger = LogManager.getLogger();

    @BeforeEach
    public void  setUp() {
        String url = "https://plus.priorbank.by/";
        WebDriver driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        driver.get(url);
        logger.info("Открываем главную страницу " + url);
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
        logger.info("Закрыли браузер и завершили сессию");
    }
}
