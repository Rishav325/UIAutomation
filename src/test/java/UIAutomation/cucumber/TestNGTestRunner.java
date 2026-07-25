package UIAutomation.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/java/UIAutomation/cucumber/Features",
        glue = "UIAutomation.cucumber.StepDefinitions",
        tags = ""
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object [][] scenarios()
    {
        return super.scenarios();
    }
}
