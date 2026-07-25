package UIAutomation.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count =0;
    int maxRetry =3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        while(count<maxRetry)
        {
            count++;
            return true;
        }
        return false;
    }
}
