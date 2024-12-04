package by.plus.priorbank.ui;

import by.plus.priorbank.ui.pages.SearchMessages;
import by.plus.priorbank.ui.pages.SearchPage;
import by.plus.priorbank.ui.steps.SearchStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchTest extends BaseTest{

    @Test
    @DisplayName("Открытие каталога")
    public void openCatalogueTest() {
        SearchStep loginStep = new SearchStep();
        loginStep.openCataloguePage();
        SearchPage searchPage = new SearchPage();
        Assertions.assertEquals(SearchMessages.HEADER_TEXT, searchPage.getHeaderText(), "Не совпадает заголовок страницы!");
    }

    @Test
    @DisplayName("Поиск продукта по названию")
    public void searchProductByName() {
        String expectedName = "21vek";
        SearchStep loginStep = new SearchStep();
        loginStep.openCataloguePage();
        loginStep.searchProduct(expectedName);
        List<String> productsNameActual = new SearchPage().getAllProductsName();
        Boolean allProductContainsExpectedName = !productsNameActual.isEmpty();
        Assertions.assertTrue(allProductContainsExpectedName, "Пустой список!");

        for (int i = 0; allProductContainsExpectedName && i < productsNameActual.size(); i++) {
            if(!productsNameActual.get(i).contains(expectedName))
                allProductContainsExpectedName = false;
        }
        Assertions.assertTrue(allProductContainsExpectedName, String.format("Не все названия продуктов содержат '%s'!", expectedName));
    }
}
