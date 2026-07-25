package UIAutomation.TestCases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ChromOptionsTest {
    @Test
    public  void chromeOptionsTest() throws InterruptedException {
        SafariOptions options = new SafariOptions();
        options.setAcceptInsecureCerts(true); // ByPass SSLCertification

        /* Set Proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        options.setCapability("proxy", proxy);*/

         //Set Download Preferences
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> DownloadPrefs = new HashMap<>();
        DownloadPrefs.put("download.default_directory", "/directory/path");
        chromeOptions.setExperimentalOption("prefs", DownloadPrefs);

       /* Run Tests In HeadLess mode
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        WebDriver driver = new ChromeDriver(chromeOptions);*/

        WebDriver driver = new SafariDriver(options);
        driver.get("https://expired.badssl.com");

        //Delete Cookie
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.close();
    }
}
