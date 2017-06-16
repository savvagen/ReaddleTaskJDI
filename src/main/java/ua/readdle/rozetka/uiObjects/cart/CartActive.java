package ua.readdle.rozetka.uiObjects.cart;


import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class CartActive extends Section {

    @FindBy(css = "div[class^='clearfix cart-i-content'] div.cart-i-title a") public TextArea productTitle;


}
