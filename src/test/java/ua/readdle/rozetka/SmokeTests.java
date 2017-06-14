package ua.readdle.rozetka;

import static ua.readdle.rozetka.JDIExampleSite.*;

import com.epam.web.matcher.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.epam.web.matcher.testng.Assert.*;

public class SmokeTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void startTest(){
        homePage.shouldBeOpened();
    }

    @Test
    public void simpleTest(){
        search();
        categoryPage.checkOpened();
        assertTrue(categoryPage.getDriver().getTitle().contains("Apple"));
        isFalse(categoryPage.productLists::isEmpty);
        assertTrue(categoryPage.producerDropdown.getWebElement("Apple").isDisplayed(),"filter \"Apple\" is not displayed");
        assertTrue(categoryPage.productLists.get(1).name.getText().contains("iPhone"), "Product with text \"iPhone\" is not displayed");
    }


    @Test
    public void openProductFromSearchResults(){
        search();
        categoryPage.checkOpened();
        categoryPage.openProduct(1);
        assertTrue(productPage.productDetails.isDisplayed());
        assertTrue(productPage.productCharacteristics.isDisplayed());
        assertFalse(productPage.productCharacteristics::isEmpty);
        assertTrue(productPage.comments.size() > 0, "Comments are empty");
        assertTrue(productPage.prouctImages.isDisplayed());
    }

    @Test
    public void addProductToCart() throws Exception{
        search();
        categoryPage.checkOpened();
        categoryPage.addToBasketProduct(1);
        String title = cartPopUp.title.getText();
        assertEquals(title, "Вы добавили товар в корзину");
        assertEquals(cartPopUp.activeProductsList.size(), 1);
        cartPopUp.close();
        String productNumber = header.cartButtonNumber.getText();
        int expectedProductNumber = Integer.parseInt(productNumber);
        assertEquals(expectedProductNumber, 1);
        header.goToCart();
        String cartTtitle = cartPopUp.title.getText();
        assertEquals(cartTtitle, "Корзина");

    }





}