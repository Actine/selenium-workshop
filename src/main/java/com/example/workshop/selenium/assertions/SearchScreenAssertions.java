package com.example.workshop.selenium.assertions;

import com.example.workshop.selenium.views.ProductListItem;
import com.example.workshop.selenium.views.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by Actine on 06.11.2016.
 */
public class SearchScreenAssertions {

    private SearchResultPage page;

    public SearchScreenAssertions(SearchResultPage page) {
        this.page = page;
    }

    public SearchScreenAssertions verifyAllItemsContainText(String expectedText) {
        Reporter.log(String.format("Verify that all items have text `%s`", expectedText));
        for (ProductListItem item : page.productListItems) {
            String actualText = item.productName.getText();
            Assert.assertTrue(
                    actualText.contains(expectedText),
                    "Item `" + actualText + "` doesn't contain `" + actualText + "`"
            );
        }
        return this;
    }
}
