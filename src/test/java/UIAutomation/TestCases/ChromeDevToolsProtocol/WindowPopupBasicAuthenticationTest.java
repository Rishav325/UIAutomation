package UIAutomation.TestCases.ChromeDevToolsProtocol;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.function.Predicate;

public class WindowPopupBasicAuthenticationTest {

    @Test
    public void basicAuthenticationTest() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        Predicate<URI> uriPredicate = uri ->  uri.getHost().contains("httpbin.org");

        ((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");
    }
}
