package com.example.workshop.selenium.steps;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * Created by Actine on 06.11.2016.
 */
public class Init extends Steps {

    public Init(WebDriver driver) {
        super(driver);
    }

    public Home openHome() {
        Reporter.log("Open home page");
        driver.get("http://automationpractice.com/");
        return new Home(driver);
    }

    public LoginScreen openLoginPage() {
        Reporter.log("Directly open log in page");
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return new LoginScreen(driver);
    }

}
