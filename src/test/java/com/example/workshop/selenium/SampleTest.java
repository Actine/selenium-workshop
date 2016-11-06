package com.example.workshop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.element.TextBlock;

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

    @Test
    public void test_OpenHomePage_EmptyCartIsPresent() {
        driver.get("http://automationpractice.com/");

        WebElement cartButton = driver.findElement(By.className("shopping_cart"));
        Assert.assertTrue(cartButton.isDisplayed());
        Assert.assertEquals(cartButton.getText(), "Cart (empty)");
    }

    @Test
    public void test_SearchForPrinted_AllItemsHavePrintedInTitle() {
        driver.get("http://automationpractice.com/");

        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys("Printed");

        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.sendKeys("q23e");

        List<WebElement> productLabels = driver.findElements(By.cssSelector("ul.product_list a.product-name"));
        for (WebElement productLabel : productLabels) {
            Assert.assertTrue(productLabel.getText().contains("Printed"));
        }
    }

    @Test
    public void test_SearchForPrinted_AllItemsHavePrintedInTitle_PageObject() {
        driver.get("http://automationpractice.com/");

        String searchedText = "Printed";

        HomePage homePage = new HomePage(driver);
        homePage.searchField.sendKeys(searchedText);
        homePage.searchButton.click();

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
        driver.get("http://automationpractice.com/");

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.productListItems.get(0).productName.getText(), "Faded Short Sleeve T-shirts");
    }

}
