package UIAutomation.TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class JavaScript_TableTest {
    @Test
    public  void JavaScript_Table_Test() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (WebElement value : values) {
            sum = sum + Integer.parseInt(value.getText());
        }

        int totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        System.out.println(sum+" "+totalAmount);
        Assert.assertEquals(sum,totalAmount);
        driver.close();
    }
}
