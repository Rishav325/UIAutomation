package UIAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class ActionsClass_Windows_FramesTest {

    @Test
    public void AjaxActionsClassTest() throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")))
                .click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();

        WebElement AccountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(AccountList).keyDown(Keys.CONTROL).click().build().perform();
        driver.quit();
    }

    @Test
    public void ChildWindowsTest() throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
        Set<String> windowsId = driver.getWindowHandles();
        Iterator<String> iterator = windowsId.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentId);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText();
        //System.out.println(emailId);
        driver.quit();
    }

    @Test
    public void FramesTest() throws IOException, InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable,droppable).build().perform();

        driver.switchTo().defaultContent();
        driver.close();
    }
}
