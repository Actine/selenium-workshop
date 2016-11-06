package com.example.workshop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author Paul Danyliuk
 * @version $Id$
 */
public class SampleTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpBeforeAll() {
        // Initialization routine is just hidden in that util method
        driver = DriverProvider.buildChromeDriver();
    }

    @AfterClass
    public void shutDownAfterAll() {
        driver.quit();
    }

    @BeforeMethod
    public void setUpBeforeEach() {
        driver.get("http://automationpractice.com/");
    }

    @Test
    public void test_OpenHomePage_EmptyCartIsPresent() {
        driver.get("http://automationpractice.com/");

        WebElement cartButton = driver.findElement(By.className("shopping_cart"));
        Assert.assertTrue(cartButton.isDisplayed());
        Assert.assertEquals(cartButton.getText(), "Cart (empty)");
    }

    @Test
    public void test_SearchForPrinted_AllItemsHavePrintedInTitle() {
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("Printed");

        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();

        List<WebElement> productLabels = driver.findElements(By.cssSelector("ul.product_list a.product-name"));
        for (WebElement productLabel : productLabels) {
            Assert.assertTrue(productLabel.getText().contains("Printed"));
        }
    }

    @Test
    public void test_SearchForPrinted_AllItemsHavePrintedInTitle_PageObject() {
        String searchedText = "Printed";

        HomePage homePage = new HomePage(driver);
        homePage.header.fillSearchText(searchedText);
        homePage.header.searchButton.click();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        for (ProductListItem item : searchResultPage.productListItems) {
            String actualText = item.productName.getText();
            Assert.assertTrue(
                    actualText.contains(searchedText),
                    "Expected " + searchedText + " but was " + actualText
            );
        }
    }

    @Test
    public void test_VerifyFirstItemOnHomePage_HasExpectedName() {

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.productListItems.get(0).productName.getText(), "Faded Short Sleeve T-shirts");
    }

    @Test
    public void test_VerifyEveningDress_HasEveningInCategory() {
        HomePage homePage = new HomePage(driver);
        homePage.header.fillSearchText("Evening");
        homePage.header.searchButton.click();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertEquals(searchResultPage.productListItems.size(), 1);

        searchResultPage.productListItems.get(0).click();
        ProductDetailsPage detailsPage = new ProductDetailsPage(driver);
        Assert.assertTrue(detailsPage.breadcrumbs.getLinkLabels().contains("Evening Dresses"));

        detailsPage.header.fillSearchText("Blouse");
        detailsPage.header.searchButton.click();

        searchResultPage = new SearchResultPage(driver);
        Assert.assertEquals(searchResultPage.productListItems.get(0).productName.getText(), "Blouse");
    }

}
