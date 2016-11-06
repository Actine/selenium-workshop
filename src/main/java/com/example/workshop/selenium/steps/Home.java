package com.example.workshop.selenium.steps;

import com.example.workshop.selenium.views.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * Created by Actine on 06.11.2016.
 */
public class Home extends Steps {

    private HomePage homePage;

    public Home(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public Header inHeader() {
        Reporter.log("In header:");
        return new Header(driver, homePage.header);
    }

}
