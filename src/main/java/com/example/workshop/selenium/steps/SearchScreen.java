package com.example.workshop.selenium.steps;

import com.example.workshop.selenium.assertions.SearchScreenAssertions;
import com.example.workshop.selenium.views.ProductListItem;
import com.example.workshop.selenium.views.SearchResultPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Actine on 06.11.2016.
 */
public class SearchScreen extends Steps {

    private SearchResultPage page;

    public SearchScreen(WebDriver driver) {
        super(driver);
        page = new SearchResultPage(driver);
    }

    public SearchScreenAssertions getAssertions() {
        return new SearchScreenAssertions(page);
    }

}
