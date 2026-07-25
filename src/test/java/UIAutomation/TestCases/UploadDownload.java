package UIAutomation.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class UploadDownload {

    @Test
    public void uploadDownload() {

        String fruitName = "Apple";
        String updatedValue = "345";
        String fileName = "/Users/rahulshetty/downloads/download.xlsx";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        //download

        driver.findElement(By.cssSelector("#downloadButton")).click();

        //Edit excel - getColumnNumber of Price -getRownumber of APple-> update excel with row,col
        //int col =getColumnNumber(fileName,"price");
        //int row = getRowNumber(fileName,"Apple");
        //Assert.assertTrue(updateCell(fileName,row,col,updatedValue));

        //upload
        WebElement upload =driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys("/Users/rishavkumar/Downloads/download.xlsx");

        //wait for success message to show up and wait for disappear
        By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        String toastText = driver.findElement(toastLocator).getText();
        System.out.println(toastText);
        Assert.assertEquals(toastText, "Updated Excel Data Successfully.");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

        //verify updated excel data showing in the web table
        String priceColumn= driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
        System.out.println(actualPrice);
        Assert.assertEquals(actualPrice, updatedValue);
    }
}