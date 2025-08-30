package UIAutomation.TestCases;

import UIAutomation.TestComponents.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class MainPageTest extends baseTest {

    @Test
    public void PageTest() throws IOException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);

        driver.close();
    }
}
