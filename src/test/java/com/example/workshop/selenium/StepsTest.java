package com.example.workshop.selenium;

import com.example.workshop.selenium.steps.Init;
import com.example.workshop.selenium.steps.SearchScreen;
import com.example.workshop.selenium.views.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Actine on 06.11.2016.
 */
public class StepsTest {

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

    private Init init() {
        return new Init(driver);
    }

    @Test
    public void test_SearchForPrinted_AllItemsHavePrintedInTitle() {
        SearchScreen searchScreen = init()
                .openHome()
                .inHeader().searchFor("Printed");
        searchScreen.getAssertions()
                .verifyAllItemsContainText("Printed");
    }


}
