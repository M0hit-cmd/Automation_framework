package testCases;

import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AddNewCustomer;
import pageObjects.Customer_Register_Success;
import pageObjects.LoginPage;
import pageObjects.ManagerHome;
import resources.StaticDataProvider;

import java.io.IOException;
import java.text.ParseException;

public class TC_AddCustomer_Test extends Base_Class {
    @Test(dataProvider = "default_customer_data",dataProviderClass = StaticDataProvider.class)
    public void addNewCustomer(String[] str) throws InterruptedException, ParseException, IOException {

        ManagerHome managerHome=new ManagerHome(driver);
        Assert.assertTrue(managerHome.welcome_message());
        managerHome.click_New_Customer();
        AddNewCustomer customer=new AddNewCustomer(driver);
        customer.fill_customer(str,browser_name);
        logger.info("Added Customer Details");
        Thread.sleep(3000);
        customer.setSubmit();
        if(isAlertPresent())
        {
            Thread.sleep(10000);
            logger.info("Unable to add new customer");
            Assert.fail();
        }
       if (driver.getPageSource().contains("Customer Registered Successfully"))
       {
           Thread.sleep(2000);
           logger.info("New Customer Created");
           Assert.assertTrue(true);
           Customer_Register_Success csr=new Customer_Register_Success(driver);
           csr.store();
           csr.click_Home();
       }
       else
       {
           logger.info("Unable to create new customer");
           Assert.fail();
       }
    }

}
