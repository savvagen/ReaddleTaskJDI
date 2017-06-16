package ua.readdle.rozetka;

import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static ua.readdle.rozetka.JDIExampleSite.*;

public class SmokeTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void startTest(){
        homePage.shouldBeOpened();
    }

    @Test(priority = 1)
    public void searchProductByWord(){
        search();
        categoryPage.checkOpened();
        assertTrue(categoryPage.getDriver().getTitle().contains("Apple"));
        Assert.isFalse(categoryPage.productLists::isEmpty);
        assertTrue(categoryPage.producerDropdown.getWebElement("Apple").isDisplayed(),"filter \"Apple\" is not displayed");
        assertTrue(categoryPage.productLists.get(1).name.getText().contains("iPhone"), "Product with text \"iPhone\" is not displayed");
    }


    @Test(priority = 2)
    public void openProductFromSearchResults(){
        search();
        categoryPage.checkOpened();
        categoryPage.openProduct(1);
        assertTrue(productPage.productDetails.isDisplayed());
        assertTrue(productPage.productCharacteristics.isDisplayed());
        Assert.assertFalse(productPage.productCharacteristics::isEmpty);
        assertTrue(productPage.comments.size() > 0, "Comments are empty");
        assertTrue(productPage.prouctImages.isDisplayed());
    }

    @Test(priority = 3)
    public void addProductToCart() {
        search();
        categoryPage.checkOpened();
        categoryPage.addToBasketProduct(1);
        String cartTitle = cartPopUp.title.getText();
        assertEquals(cartPopUp.title.getText(), "Вы добавили товар в корзину");
        cartPopUp.close();

    }

    @Test(dependsOnMethods = "addProductToCart")
    public void checkCartAferProductAding(){
        String productNumber = header.cartButtonNumber.getText();
        int expectedProductNumber = Integer.parseInt(productNumber);
        assertEquals(expectedProductNumber, 1);
        header.goToCart();
        String cartTtitle = cartPopUp.title.getText();
        assertEquals(cartTtitle, "Корзина");
    }





}
