package testCases;

import net.bytebuddy.implementation.FieldAccessor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import utils.Grid;
import utils.ReadConfig;
import utils.Read_details;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;


public class Base_Class {
    ReadConfig readConfig = new ReadConfig();
    public String baseUrl = readConfig.getUrl();
    public String userName = readConfig.getUserName();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;
    public String cust_id= readConfig.getCust_id();
    public static int count=1;
    public static String browser_name;
    @BeforeTest
    @Parameters({"browserName"})
    public void setup(String browserName) throws MalformedURLException {
        browser_name=browserName;
        logger= Logger.getLogger("ebanking");
        driver = Grid.initializeBrowser(browserName);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        Read_details rd=new Read_details();
        rd.cleanUpProp();
    }
    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException exp)
        {
            return false;
        }
    }
}