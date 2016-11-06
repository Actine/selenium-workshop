package com.example.workshop.selenium.steps;

import com.example.workshop.selenium.views.HeaderView;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * Created by Actine on 06.11.2016.
 */
public class Header extends Steps {

    private HeaderView header;

    public Header(WebDriver driver, HeaderView header) {
        super(driver);
        this.header = header;
    }

    public SearchScreen searchFor(String what) {
        Reporter.log(String.format("Type `%s` in search box and press search button", what));
        header.fillSearchText(what);
        header.searchButton.click();
        return new SearchScreen(driver);
    }
}
