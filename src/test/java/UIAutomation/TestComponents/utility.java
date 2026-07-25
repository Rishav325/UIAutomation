package UIAutomation.TestComponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class utility {

    public static String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"//report//" + testCaseName +".PNG");
        FileUtils.copyFile(source,destination);
        return System.getProperty("user.dir")+"//report//" + testCaseName +".PNG";
    }
}
