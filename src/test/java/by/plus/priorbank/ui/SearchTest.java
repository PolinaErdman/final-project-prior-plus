package by.plus.priorbank.ui;

import by.plus.priorbank.ui.pages.search.SearchMessages;
import by.plus.priorbank.ui.pages.search.SearchPage;
import by.plus.priorbank.ui.steps.SearchStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

public class SearchTest extends BaseTest{

    @Test
    @DisplayName("Открытие каталога")
    public void openCatalogueTest() {
        SearchStep searchStep = new SearchStep();
        searchStep.openCataloguePage();
        SearchPage searchPage = new SearchPage();
        Assertions.assertEquals(SearchMessages.HEADER_TEXT, searchPage.getHeaderText(), "Не совпадает заголовок страницы!");
    }

    @Test
    @DisplayName("Поиск продукта по названию")
    public void searchProductByName() {
        String expectedName = "21vek";
        SearchStep searchStep = new SearchStep();
        searchStep.openCataloguePage();
        searchStep.searchProduct(expectedName);
        List<String> productsNameActual = new SearchPage().getAllProductsName();
        boolean isAllProductContainsExpectedName = !productsNameActual.isEmpty();
        Assertions.assertTrue(isAllProductContainsExpectedName, "Пустой список!");
        isAllProductContainsExpectedName = searchStep.isAllProductContainsExpectedName(productsNameActual, expectedName);
        Assertions.assertTrue(isAllProductContainsExpectedName, String.format("Не все названия продуктов содержат '%s'!", expectedName));
    }
}
