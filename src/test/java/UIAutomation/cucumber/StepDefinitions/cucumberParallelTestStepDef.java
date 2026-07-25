package UIAutomation.cucumber.StepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class cucumberParallelTestStepDef {

    @Given("Step from {string} in {string} feature file")
    public void step_from_in_feature_file(String TestCase, String featureFileName) throws InterruptedException {
        System.out.println(TestCase+" : "+featureFileName);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.quit();
    }
}
