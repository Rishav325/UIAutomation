package UIAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticDropDownTest {

    @Test
    public void DropDownTest() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Select dropdownElement = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdownElement.selectByIndex(1);
        dropdownElement.selectByValue("option2");
        dropdownElement.selectByVisibleText("Option3");
        System.out.println(dropdownElement.getFirstSelectedOption().getAttribute("value"));
        Thread.sleep(500);
        driver.close();
    }

    @Test
    public void ValidateDropDownValuesTest() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        List<String> expectedOptions = Arrays.asList("Select","Option1","Option2","Option3");
        Select dropdownElement = new Select(driver.findElement(By.id("dropdown-class-example")));
        List<WebElement> dropDownOptions = dropdownElement.getOptions();
        List<String> actualOptions = new ArrayList<>();
        for(WebElement element:dropDownOptions)
        {
            actualOptions.add(element.getText());
        }
        System.out.println(actualOptions.toString());
        Assert.assertEquals(expectedOptions,actualOptions);
        driver.close();
    }

    @Test
    public void SpiceJetDropDownTest() throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.spicejet.com");
        driver.manage().window().maximize();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-testid='home-page-travellers']")));

        WebElement passengerDropdown = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']"));
        System.out.println(passengerDropdown.getText());
        passengerDropdown.click();

        WebElement selectAdult = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
        int i = 0;
        while(i<4)
        {
            selectAdult.click();
            i++;
        }
        System.out.println(passengerDropdown.getText());
        driver.close();
    }
}
