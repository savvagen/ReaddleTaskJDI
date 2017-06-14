package ua.readdle.rozetka.uiObjects.catalog;


import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends Section {

    @FindBy(css = "div.g-i-tile-i-box-desc div[class^='g-i-tile-i-title clearfix'] a")
    public Link name;
    @FindBy(css = "div.g-i-tile-i-box-desc div[name^='prices_active_element_original'] div > div[name^='price'] > div")
    public Link price;
    @FindBy(css = "div.g-i-tile-i-box-desc div.clearfix div[class^='g-i-tile-i-image fix-height'] a img")
    public Link image;


}
