package UIAutomation.TestCases.ChromeDevToolsProtocol;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.Request;
import org.openqa.selenium.devtools.v139.network.model.Response;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.Optional;
import java.util.function.Predicate;

public class NetworkLogActivityTest {

    @Test
    public void networkLogActivityTest() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(),
                Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request ->
        {
            Request req = request.getRequest();
            System.out.println(req.getUrl());
        });

        //Event will get fired-
        devTools.addListener(Network.responseReceived(), response ->
        {
            Response res = response.getResponse();
            System.out.println(res.getUrl());
            System.out.println(res.getStatus());
            if(res.getStatus()>=400)
            {
                System.out.println(res.getUrl()+"is failing with status code"+res.getStatus());
            }
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
