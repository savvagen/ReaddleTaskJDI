package ua.readdle.rozetka.utilites;



import com.epam.web.matcher.verify.Verify;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import static com.google.common.io.Files.toByteArray;

import org.slf4j.Logger;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Helpers {

    public static FileWriter fileWriter;
    public static PrintWriter printWriter;


    public static final String LOG_DIR = "src/main/logs";

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("appLogger");


    @Attachment(value = "Test log")
    public static String attacheText(String text) {
        //log.info("Taking test log to allure report");
        return text;
    }

    /*@Attachment
    public static byte[] attachScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
*/

    @Attachment
    public static byte[] attachScreenshot() {
        //return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return (Verify.screenshotAction).get().getBytes();
    }


    @Attachment("Test log(see in the end)")
    public static byte[] attachLog(String name) {
        try {
            File file = new File(LOG_DIR + "/" + name + ".log");
            return toByteArray(file);
        } catch (Exception ignored) {
            return new byte[0];
        }
    }



    /*@Attachment(value = "{0}", type = "text/html")
    public static byte[] attachHtml(final String name, final String templateName, final Map<String, Object> args) {
        final String outName = "target" + File.separator + "attachment" + COUNTER.incrementAndGet();
        try {
            execute(templateName, outName, args);
            return toByteArray(new File(outName));
        } catch (Exception ignored) {
            return new byte[0];
        }
    }*/


    public static void clearLog() throws IOException {
        fileWriter = new FileWriter("src/main/logs/events.log", false);
        printWriter = new PrintWriter(fileWriter, false);
        printWriter.flush();
        printWriter.close();
        fileWriter.close();
    }
}