package by.plus.priorbank.ui.steps;

import by.plus.priorbank.ui.pages.login.LoginPage;
import by.plus.priorbank.ui.pages.search.SearchPage;
import java.util.List;

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

    public boolean isAllProductContainsExpectedName(List<String> productsNameActual, String expectedName) {
        for (String string : productsNameActual) {
            if (!string.contains(expectedName))
                return false;
        }
        return true;
    }
}
