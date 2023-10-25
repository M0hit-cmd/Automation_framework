package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import utils.ReadConfig;

import java.io.IOException;
import java.time.Duration;


public class Base_Class {
    ReadConfig readConfig = new ReadConfig();
    public String baseUrl = readConfig.getUrl();
    public String userName = readConfig.getUserName();
    public String password = readConfig.getPassword();
    public static WebDriver driver;

    @BeforeClass
    @Parameters({"browserName"})
    public void setup(String browserName) {

        if (browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browserName.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if (browserName.equalsIgnoreCase("edge"))
            driver = new EdgeDriver();
        else
            Assert.fail();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}