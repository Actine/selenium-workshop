package com.example.workshop.selenium.views;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.List;

/**
 * Created by Actine on 06.11.2016.
 */
public class ProductListItem extends HtmlElement {

    @FindBy(css = "a.product-name")
    public Link productName;

    @FindBy(css = "a.ajax_add_to_cart_button")
    public Button addToCartButton;

    public void click() {
        productName.click();
    }
}
