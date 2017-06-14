package ua.readdle.rozetka;


import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;




public class TestBase extends TestNGBase {

    public static WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public static void setUp() throws Exception {
        WebSite.init(JDIExampleSite.class);
        logger.info("Run Tests");
    }



    @AfterMethod
    public void tearDown() {
        Verify.getFails();
    }




}
