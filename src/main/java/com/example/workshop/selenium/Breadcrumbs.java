package com.example.workshop.selenium;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Actine on 06.11.2016.
 */
@FindBy(className = "breadcrumb")
public class Breadcrumbs extends HtmlElement {

    @FindBy(tagName = "a")
    private List<Link> breadcrumbs;

    public List<String> getLinkLabels() {
        List<String> labels = new ArrayList<String>();
        for (Link link : breadcrumbs) {
            labels.add(link.getText());
        }
        return labels;
    }

}
