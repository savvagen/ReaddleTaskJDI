package ua.readdle.rozetka.uiObjects.header;


import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;

import org.openqa.selenium.support.FindBy;
import ua.readdle.rozetka.entities.Search;

public class SearchForm extends Form<Search>{

    @FindBy(css = "input[class^='rz-header-search-input-text passive']")
    public ITextField searchField;
    @FindBy(name = "rz-search-button")
    public IButton searchButton;


}
