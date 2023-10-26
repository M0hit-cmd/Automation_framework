package testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AddNewCustomer;
import pageObjects.Customer_Register_Success;
import pageObjects.LoginPage;
import pageObjects.ManagerHome;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.logging.Logger;

public class TC_LoginTest001 extends Base_Class {
    @Test(priority = 0)
    public void loginTest() throws InterruptedException, MalformedURLException, ParseException {

        logger.info("URl is opened");

        LoginPage login_obj = new LoginPage(driver);
        Assert.assertNotNull(baseUrl);
        login_obj.setUserName(userName);
        logger.info("Entered userName");
        login_obj.setPassword(password);
        logger.info("Entered password");
        login_obj.login();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else {
            Assert.fail();
            logger.info("Login test failed");
        }

        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void managerHomeTest(){

        ManagerHome managerHome=new ManagerHome(driver);
        Assert.assertTrue(managerHome.welcome_message());
        managerHome.click_New_Customer();
    }
    @Test(dataProvider = "customer_data" ,priority=3)
    public void add_customer(String[] objects) throws ParseException, InterruptedException, IOException {

        AddNewCustomer customer=new AddNewCustomer(driver);
        customer.
        fill_customer(objects);
        Thread.sleep(5000);
        customer.setSubmit();
        Customer_Register_Success c1=new Customer_Register_Success(driver);
        c1.store();
        Thread.sleep(6000);
    }
    @DataProvider(name="customer_data")
    public String[][] customer_data_provider(){
        String[][]obj=new String[][]{{"Rohit Sharma","Male","07022000","Address of Rohit","Mumbai","Maharashtra","100902","9894820999","rohit_sharma_030934@gmail.com","ABC@121004"},{"Radha","Female","01012001","Address of Radha","New Delhi","Delhi","121005","8989838582","radha_rahul_0493@gmail.com","ABC@121004"}};
        return new String[][]{{"Rohit","Male","06101998","Address of Mohit","Faridabad","Haryana","121004","8888688888","mohit_singh099_12234_2@gmail.com","ABC@121004"}};

    }



}
