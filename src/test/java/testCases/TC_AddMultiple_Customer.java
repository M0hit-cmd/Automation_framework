package testCases;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AddNewCustomer;
import pageObjects.Customer_Register_Success;
import pageObjects.LoginPage;
import pageObjects.ManagerHome;
import resources.StaticDataProvider;
import utils.Grid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

public class TC_AddMultiple_Customer extends Base_Class {
    ManagerHome managerHome;
    LoginPage lp;
    AddNewCustomer customer;

    @BeforeMethod
    public void bfrMethod_multi_cust() throws MalformedURLException {
        lp = new LoginPage(driver);
        lp.setUserName(userName);
        lp.setPassword(password);
        lp.login();
        managerHome = new ManagerHome(driver);
        Assert.assertTrue(managerHome.welcome_message());
        managerHome.click_New_Customer();
    }

    @Test(dataProvider = "customer_data",dataProviderClass = StaticDataProvider.class)
    public void test_multi_cust(String[] objects) throws InterruptedException, ParseException, IOException {
        customer = new AddNewCustomer(driver);
        customer.fill_customer(objects,browser_name);
        Thread.sleep(5000);
        customer.setSubmit();
        Thread.sleep(5000);
        if (driver.getPageSource().contains("Customer Registered Successfully")) {
            Assert.assertTrue(true);
            Customer_Register_Success csr=new Customer_Register_Success(driver);
            csr.store();
        } else {
            logger.warning("Customer already exists");
            Assert.fail();
        }
    }




    @AfterMethod
    public void afterMethod() throws InterruptedException {
        managerHome.click_Log_out();
        Thread.sleep(2000);
        if(isAlertPresent()) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            logger.info("logout sucessfully");
        }
    }

}
