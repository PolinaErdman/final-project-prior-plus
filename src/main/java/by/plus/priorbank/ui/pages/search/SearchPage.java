package by.plus.priorbank.ui.pages.search;

import by.plus.priorbank.ui.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public SearchPage() {
        driver = Driver.getDriver();
    }

    public String getHeaderText() {
        String headerText = driver.findElement(By.tagName(SearchXpath.HEADER_TAG_NAME)).getText();
        logger.info(String.format("Получили заголовок страницы = '%s'", headerText));
        return headerText;
    }

    public void setProductName(String productName) {
        driver.findElement(By.xpath(SearchXpath.INPUT_PRODUCT_NAME_XPATH)).sendKeys(productName);
        logger.info(String.format("Установили название продукта = '%s'", productName));
    }

    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.xpath(SearchXpath.BUTTON_SEARCH_XPATH));
        new Actions(driver).scrollToElement(searchButton).perform();
        searchButton.click();
        logger.info("Кликнули на кнопку 'Поиск'");
    }

    public List<String> getAllProductsName() {
        List<String> nameList = new ArrayList<String>();
        List<WebElement> productsName = driver.findElements(By.xpath(SearchXpath.TEXT_PRODUCT_NAME_XPATH));

        for(WebElement productName : productsName) {
            String name = productName.getText();
            logger.info(String.format("Получили название продукта = '%s'", name));
            nameList.add(name);
        }

        logger.info(String.format("Получили список продуктов %d шт.", nameList.size()));
        return nameList;
    }
}
