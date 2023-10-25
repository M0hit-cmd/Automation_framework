package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AddNewCustomer;
import pageObjects.LoginPage;
import pageObjects.ManagerHome;

import java.text.ParseException;

public class DummyTest  {
    WebDriver driver;
    @BeforeTest
    public void setupp() {
        driver=new ChromeDriver();
        LoginPage login_obj = new LoginPage(driver);
        String url = "https://demo.guru99.com/v4/index.php";
        Assert.assertNotNull(url);
        driver.get(url);
        login_obj.setUserName("mngr534116");
        login_obj.setPassword("hUmYqyv");
        login_obj.login();
    }

    @Test
    public void testi() throws ParseException {
        ManagerHome home = new ManagerHome(driver);
        home.click_New_Customer();
        AddNewCustomer newCustomer = new AddNewCustomer(driver);
        newCustomer.fill_customer_name("Mohit");
        newCustomer.click_male();
//        newCustomer.selectDate();
    }

    @Test
    public void testi2() throws ParseException {
        ManagerHome home = new ManagerHome(driver);
        home.click_New_Customer();
        AddNewCustomer newCustomer = new AddNewCustomer(driver);
        newCustomer.fill_customer_name("Sachin");
        newCustomer.click_male();
//        newCustomer.selectDate();
    }

}
