package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import static fileReaders.FileReaders.getPropertyByKey;


public class BaseTests {

    WebDriver driver;

    @BeforeMethod
    public void setup_initiateDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(getPropertyByKey("configData.properties","App_URL"));
    }

    @AfterMethod
    public void a_takeScreenshotForFailedTests(ITestResult result) {
        String destination = "./screenshots/" + result.getName() + ".png" ;
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                //To add it in the extent report
                FileUtils.copyFile(screenshot, new File(destination));
            } catch (IOException e) {
                // handle
            }
        }
    }

    @AfterMethod
    public void z_quitDriver() {
        driver.quit();
    }

}
