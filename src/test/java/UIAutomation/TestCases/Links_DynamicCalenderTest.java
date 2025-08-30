package UIAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Links_DynamicCalenderTest {

    @Test
    public  void LinksTest() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        //1. Give me the count of links on the page.
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. Count number of Links of footer section
        WebElement footerDriver =driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //3- Count number of Links in Colum inside footer section
        WebElement columDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        List<WebElement> columLinks = columDriver.findElements(By.tagName("a"));
        System.out.println(columLinks.size());

        //4- click on each link in the column and check if the pages are opening
        for(int i = 1; i< columLinks.size(); i++)
        {
            System.out.println(columLinks.get(i).getAttribute("href"));
            String clickOnlink = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columLinks.get(i).sendKeys(clickOnlink);
        }
        // opens all the tabs
        Set<String> abc=driver.getWindowHandles();//4
        Iterator<String> it=abc.iterator();

        while(it.hasNext())
        {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
        driver.close();
    }
}
