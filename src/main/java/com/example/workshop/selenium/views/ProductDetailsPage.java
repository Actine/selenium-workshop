package com.example.workshop.selenium.views;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by Actine on 06.11.2016.
 */
public class ProductDetailsPage {

    public Breadcrumbs breadcrumbs;

    public HeaderView header;

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

}
