package UIAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxAndRadioButtonTest {
    @Test
    public  void CheckBoxTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        // parentXpath-ChildXpath
        List<WebElement> DiscountCheckBoxes = driver.findElements(By.xpath("//div[@id='discount-checkbox']//input[@type='checkbox']"));
        System.out.println(DiscountCheckBoxes.size());
        WebElement IndianArmForceCheckBox = driver.findElement(By.cssSelector("input[id*='IndArm']"));
        System.out.println(IndianArmForceCheckBox.isSelected());
        IndianArmForceCheckBox.click();
        System.out.println(IndianArmForceCheckBox.isSelected());
        driver.close();
    }

    @Test
    public  void RadioButtonTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        WebElement roundTripRadioButton = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']"));
        roundTripRadioButton.click();
        WebElement calendarIcon = driver.findElement(By.id("Div1"));
        if(calendarIcon.getDomAttribute("style").contains("1"))
        {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
        driver.close();
    }
}
