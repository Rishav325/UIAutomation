package UIAutomation.TestCases;

import org.testng.annotations.*;

public class TestNGFeaturesTest {

    @Test(invocationCount = 2)//runs 2 Times
    @Parameters({"MyAge","MyName"})
    public void parameterTest(String MyAge,String MyName)
    {
        System.out.println("My Age:"+MyAge);
        System.out.println("My Name:"+MyName);
    }

    @Test()
    @Ignore
    public void IgnoreTest()
    {
        System.out.println("This Test will be Ignored");
    }

    @BeforeSuite()
    public void beforeSuiteTest()
    {
        System.out.println("BeforeSuite Annotation");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("BeforeTest Annotation");
    }
    @BeforeClass
    public void beforeClass()
    {
        System.out.println("BeforeClass Annotation");
    }
    @BeforeMethod()
    public void beforeMethod()
    {
        System.out.println("BeforeMethod Annotation");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("AfterMethod Annotation");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("AfterClass Annotation");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("AfterTest Annotation");
    }
    @AfterSuite
    public void afterSuite()
    {
        System.out.println("AfterSuite Annotation");
    }
    @Test(groups = "Smoke")
    public void SmokeGroupTest1()
    {
        System.out.println("Smoke Group Test1");
    }
    @Test(groups = "Smoke")
    public void SmokeGroupTest2()
    {
        System.out.println("Smoke Group Test2");
    }
    @Test(priority = -1)
    public void priorityTest()
    {
        System.out.println("Priority Test with priority -1");
    }
}
