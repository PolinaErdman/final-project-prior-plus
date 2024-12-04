package by.plus.priorbank.ui.steps;

import by.plus.priorbank.ui.pages.LoginPage;
import by.plus.priorbank.ui.pages.SearchPage;

public class SearchStep {
    public void openCataloguePage() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickCatalogueButton();
    }

    public void searchProduct(String productName) {
        SearchPage searchPage = new SearchPage();
        searchPage.setProductName(productName);
        searchPage.clickSearchButton();
    }
}
