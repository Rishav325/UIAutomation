package UIAutomation.TestCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ScreenShot_BrokenLinkTest {

    @Test
    public void ScreenShotTest() throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();

        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("/Users/rishavkumar/Desktop/MyLearning/UIAutomation/target/Screenshot.PNG");
        FileUtils.copyFile(source,destination);
        driver.close();
    }

    @Test
    public void checkBrokenLinksTest() throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a =new SoftAssert();
        for(WebElement link : links)
        {
            String url= link.getAttribute("href");
            HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode);
            a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
        }
        a.assertAll();
        driver.close();
    }
}
