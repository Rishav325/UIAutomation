package UIAutomation.TestCases.ChromeDevToolsProtocol;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

public class EmulateNetworkSpeedTest {

    @Test
    public void emulateNetworkSpeedTest() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(),
                Optional.empty(),Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 100000
                ,Optional.of(ConnectionType.ETHERNET),Optional.empty(),Optional.empty(),
                Optional.empty()));

        devTools.addListener(Network.loadingFailed(), loadingFailed->
        {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });
        long startTime = System.currentTimeMillis();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
        String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
        System.out.println(title);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        driver.close();
    }
}
