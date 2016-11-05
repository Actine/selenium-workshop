package com.example.workshop.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

}
