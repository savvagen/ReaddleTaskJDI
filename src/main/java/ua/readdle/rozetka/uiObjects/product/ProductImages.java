package ua.readdle.rozetka.uiObjects.product;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.complex.DropList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProductImages extends Section {

    @FindBy(css = "div#preview_scroller div.details-img-slider div#preview_details div.detail-img-thumbs-l-i")
    public List aditionalImages;

    @FindBy(css = "div#figure_basic_image")
    public Element mainImage;

}
