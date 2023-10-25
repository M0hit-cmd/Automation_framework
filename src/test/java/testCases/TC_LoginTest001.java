package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AddNewCustomer;
import pageObjects.LoginPage;
import pageObjects.ManagerHome;
import utils.FillNewCustomer;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.logging.Logger;

public class TC_LoginTest001 extends Base_Class {

    @Test
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
        AddNewCustomer newCustomer = new AddNewCustomer(driver);
//        fill_customer(newCustomer,)

        Thread.sleep(3000);
    }
    @Test
    public void managerHomeTest(){
        ManagerHome managerHome=new ManagerHome(driver);
        Assert.assertTrue(managerHome.welcome_message());
    }


    private void fill_customer(AddNewCustomer newCustomer,Object[][] objects) throws ParseException {

        newCustomer.fill_customer_name("Mohit");
        newCustomer.click_male();
        newCustomer.selectDate("01022007");
    }


}
