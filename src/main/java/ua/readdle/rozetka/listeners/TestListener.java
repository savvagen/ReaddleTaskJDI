package ua.readdle.rozetka.listeners;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;
import ua.readdle.rozetka.utilites.Helpers;

import java.io.IOException;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;


public class TestListener extends TestNG.ExitCodeListener {


    public static final Logger log = Logger.getRootLogger();


    @Override
    public void onTestStart(ITestResult testResult) {
        super.onTestStart(testResult);
        try {
            Helpers.clearLog();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("****************************************************************************************");
        log.info("****************************************************************************************");
        log.info("$$$$$$$$$$$$$$$$$$$$$                 " + testResult.getMethod().getMethodName() + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("****************************************************************************************");
        log.info("****************************************************************************************");

    }


    @Override
    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
        log.info("X");
        log.info("X");
        log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-FAILED-" + "             XXXXXXXXXXXXXXXXXXXXXX");
        log.info("X");
        log.info("X");
        log.error("Test \"" + testResult.getMethod().getMethodName() + "\""
                + " test failed________" + "\n" + testResult.getThrowable().toString());
        Helpers.attachLog("events");
        Helpers.attachScreenshot();

    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        super.onTestSuccess(testResult);
        log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
        log.info("X");
        log.info("X");
        log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-SUCCESS-" + "             XXXXXXXXXXXXXXXXXXXXXX");
        log.info("X");
        log.info("X");
        log.info("\"" + testResult.getMethod().getMethodName() + "\"" + " test finished with success________");
        Helpers.attachLog("events");
    }

    @Override
    public void onFinish(ITestContext context) {

    }



}
