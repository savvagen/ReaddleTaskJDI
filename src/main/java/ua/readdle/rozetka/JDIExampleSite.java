package ua.readdle.rozetka;


import com.epam.jdi.uitests.core.interfaces.complex.interfaces.CheckPageTypes;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ua.readdle.rozetka.entities.Search;
import ua.readdle.rozetka.pages.CategoryPage;
import ua.readdle.rozetka.pages.HomePage;
import ua.readdle.rozetka.pages.ProductPage;
import ua.readdle.rozetka.uiObjects.cart.CartPopUp;
import ua.readdle.rozetka.uiObjects.header.Header;
import ua.readdle.rozetka.uiObjects.header.SearchForm;

@JSite(domain = "http://rozetka.com.ua")
public class JDIExampleSite extends WebSite {

    @JPage(url = "/", title = "Интернет-магазин ROZETKA™: фототехника, видеотехника, аудиотехника, компьютеры и компьютерные комплектующие", urlCheckType = CheckPageTypes.EQUAL, titleCheckType = CheckPageTypes.CONTAINS)
    public static HomePage homePage;
    @JPage(url = "/mobile-phones/apple/c80003/v069/", title = "Мобильные телефоны Apple (Эпл) - Rozetka.ua | Мобильные телефоны Apple (Эпл) в Киеве: цена, отзывы, продажа, купить.", urlCheckType = CheckPageTypes.CONTAINS, titleCheckType = CheckPageTypes.EQUAL)
    public static CategoryPage categoryPage;
    @JPage()
    public static ProductPage productPage;

    public static SearchForm searchForm;
    public static CartPopUp cartPopUp;
    public static Header header;


    @Step("search")
    public static void search() {
        searchForm.search(new Search());
    }

    @Step(" search with text: \"{0}\"")
    public static void search(String text){
        searchForm.searchField.newInput("iphone");
        searchForm.searchButton.click();
    }



}
