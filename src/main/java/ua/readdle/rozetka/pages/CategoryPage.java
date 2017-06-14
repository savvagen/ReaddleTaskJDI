package ua.readdle.rozetka.pages;


import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ua.readdle.rozetka.uiObjects.catalog.ProductBlock;
import ua.readdle.rozetka.uiObjects.catalog.ProductList;

import java.util.List;

public class CategoryPage extends WebPage {

    @JDropdown(
            root = @FindBy(css = "div[param^='producer']"),
            list = @FindBy(css = "ul#sort_producer li"),
            value = @FindBy(css = "i.filter-parametrs-i-l-i-default-title")
            //expand = @FindBy(tagName = "li")
    ) public Dropdown producerDropdown;

    @FindBy(css = "div[name^='goods_list'] div[data-split^='1']")
    public List<ProductList> productLists;
    @FindBy(css = "div[name^='goods_list'] div[data-split^='1']")
    public Elements<ProductBlock> productSearchBlock;

    @Step("open product")
    public void openProduct(int index){
        productLists.get(index).image.click();
    }

    @Step("open product")
    public void openProduct(String name){
        productSearchBlock.get(name).image.click();
    }

    public void addToBasketProduct(int number){
        productLists.get(number).addToCart.click();
    }


    // div.over-wraper > div > div.g-i-tile-i-box div.g-i-tile-i-box-desc div[class^='g-i-tile-i-title clearfix'] a





}
