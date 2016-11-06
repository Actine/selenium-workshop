package com.example.workshop.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * Created by Actine on 06.11.2016.
 */
public class HomePage {

    @FindBy(id = "search_query_top")
    public TextInput searchField;

    @FindBy(name = "submit_search")
    public Button searchButton;

    @FindBy(className = "product-container")
    public List<ProductListItem> productListItems;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

}
