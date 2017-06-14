package ua.readdle.rozetka.uiObjects.header;


import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.*;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.awt.*;
import java.awt.TextArea;


public class Header extends Form {

    @FindBy(css = "div[name^='splash-button'] div a") public Button cartButton;
    @FindBy(css = "div[class^='header-popup header-popup-cart-full'] a")
    Link cartlink;

    @FindBy(css = "div[name^='splash-button'] div a span.hub-i-count") public TextField cartButtonNumber;

    @Step
    public void goToCart(){
        cartButton.click();
        cartlink.click();

    }



}
