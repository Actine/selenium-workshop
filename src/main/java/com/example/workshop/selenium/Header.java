package com.example.workshop.selenium;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Actine on 06.11.2016.
 */
@FindBy(className = "header-container")
public class Header extends HtmlElement {

    @FindBy(id = "search_query_top")
    private TextInput searchField;

    @FindBy(name = "submit_search")
    public Button searchButton;

    public void fillSearchText(String what) {
        searchField.clear();
        searchField.sendKeys(what);
    }

}
