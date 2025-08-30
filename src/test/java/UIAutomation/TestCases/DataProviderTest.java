package UIAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderTest {

    @Test(dataProvider="TestData")
    public void dataProviderTest(String userName, String passWord) throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();

        WebElement userNameTextBox = driver.findElement(By.id("username"));
        WebElement passWordTextBox = driver.findElement(By.id("password"));
        userNameTextBox.sendKeys(userName);
        passWordTextBox.sendKeys(passWord);
        driver.close();
    }

    @DataProvider(name = "TestData")
    public Object[][] getTestData()
    {
        return new Object[][]{
                {"username","pass123"},
                {"rkuql","467rhfd"},
                {"dbf","ryhdt234"}
        };
    }
}
