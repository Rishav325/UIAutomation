package UIAutomation.TestCases.ChromeDevToolsProtocol;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.util.List;

public class ConsoleLogCaptureTest {

    @Test
    public void consoleLogCaptureTest() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.partialLinkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        LogEntries entry= driver.manage().logs().get(LogType.BROWSER); //Get LogEntries object
        List<LogEntry> logs = entry.getAll();  //LogEntryobject- getAll method return all logs in list

        for(LogEntry e : logs)//iterating through list and printing each log message
        {
            System.out.println(e.getMessage());  //Log4j

        }
    }
}
