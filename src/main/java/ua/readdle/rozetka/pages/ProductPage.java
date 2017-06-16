package ua.readdle.rozetka.pages;


import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import ua.readdle.rozetka.uiObjects.product.CharacterisictsSection;
import ua.readdle.rozetka.uiObjects.product.DescriptionSection;
import ua.readdle.rozetka.uiObjects.product.ProductImages;
import ua.readdle.rozetka.uiObjects.product.ReviewSection;

import java.util.List;

public class ProductPage extends WebPage {

    @FindBy(className = "detail-title") public Label productName;
    @FindBy(className = "detail-tabs-i") public Elements<DescriptionSection> productDetails;
    @FindBy(name = "characteristics")public Elements<CharacterisictsSection> productCharacteristics;
    @FindBy(css = "section#comments_block div#comments article.pp-review-i") public List<ReviewSection> comments;
    @FindBy(css = "div.detail-img") public Elements<ProductImages> prouctImages;

    @FindBy(id = "cart-popup") public Form cartPopUp;



}

