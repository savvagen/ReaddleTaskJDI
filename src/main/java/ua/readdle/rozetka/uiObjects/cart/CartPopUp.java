package ua.readdle.rozetka.uiObjects.cart;


import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;



public class CartPopUp extends Form {


    @FindBy(className = "popup-close") public Button close;
    @FindBy(className = "cart-title") public TextArea title;
    @FindBy(css = "div[class^='clearfix cart-i cart-added active'] div.cart-info']")
    public Elements<CartActive> activeProducts;

    public void close(){
        close.click();
    }


}
