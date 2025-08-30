package UIAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class DynamicDropDownTest {

    @Test
    public void SpiceJetDropDownTest() throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.spicejet.com");
        driver.manage().window().maximize();
        driver.get("http://spicejet.com");

        driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
        driver.findElement(By.xpath("//*[text()='VTZ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='JSA']")).click();
        driver.close();
    }

    @Test
    public  void AutoSuggestDropDownTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(5000);
        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option :options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
            }
        }
        driver.close();
    }
}