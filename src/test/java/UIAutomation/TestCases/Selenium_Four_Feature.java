package UIAutomation.TestCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium_Four_Feature {

    @Test
    public void RelativeLocatorsTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //above()
        WebElement nameEditTextBox = driver.findElement(By.cssSelector("input[name='name']"));
        WebElement nameLabel = driver.findElement(with(By.tagName("label")).above(nameEditTextBox));
        System.out.println(nameLabel.getText());

        //below()
        WebElement iceCreamCheckBox = driver.findElement(By.id("exampleCheck1"));
        WebElement genderLabel = driver.findElement(with(By.tagName("label")).below(iceCreamCheckBox));
        System.out.println(genderLabel.getText());

        //toRightOf()
        WebElement loveIceCreamLabel = driver.findElement(with(By.tagName("label")).toRightOf(iceCreamCheckBox));
        System.out.println(loveIceCreamLabel.getText());

        //toLeftOf()
        WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

        driver.close();
    }

    @Test
    public void OpenMultipleWindowsTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB); //for Window WindowType.WINDOW
        Set<String> windowsId = driver.getWindowHandles();
        Iterator<String> ids = windowsId.iterator();
        String parentId = ids.next();
        String childId = ids.next();

        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        driver.switchTo().window(parentId);
        WebElement nameEditTextBox = driver.findElement(By.cssSelector("input[name='name']"));
        nameEditTextBox.sendKeys(courseName);

        driver.quit();
    }

    @Test
    public void takeElementScreenShotTest() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditTextBox = driver.findElement(By.cssSelector("input[name='name']"));
        nameEditTextBox.sendKeys("Hi I am Taking ScreenShot Now");
        File source = nameEditTextBox.getScreenshotAs(OutputType.FILE);
        File destination = new File("report/ElementScreenShot.PNG");
        FileUtils.copyFile(source,destination);

        // get Height and Width of Element
        int nameEditTextBoxHeight = nameEditTextBox.getRect().getDimension().getHeight();
        int nameEditTextBoxWidth = nameEditTextBox.getRect().getDimension().getWidth();
        System.out.println(nameEditTextBoxHeight+":"+nameEditTextBoxWidth);

        driver.close();
    }
}
