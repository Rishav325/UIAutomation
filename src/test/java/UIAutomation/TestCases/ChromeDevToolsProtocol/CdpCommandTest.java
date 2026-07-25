package UIAutomation.TestCases.ChromeDevToolsProtocol;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CdpCommandTest {

    @Test(enabled = false)
    public void cdpCommandTest() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        HashMap<String,Object> deviceMatrix = new HashMap<>();
        deviceMatrix.put("width",390);
        deviceMatrix.put("height",844);
        deviceMatrix.put("deviceScaleFactor",42);
        deviceMatrix.put("mobile",true);
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMatrix);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Library")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
