package UIAutomation.TestCases.ChromeDevToolsProtocol;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.Optional;

public class MobileEmulatorTest {

    @Test
    public void mobileEmulatorTest() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setDeviceMetricsOverride(390,844,42,true,
                Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),
                Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),
                Optional.empty()));
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Library")).click();
        Thread.sleep(5000);
        driver.close();
    }
}
