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

public class TC_LoginTest001 extends Base_Class {
    @Test
    public void loginTest() throws InterruptedException, MalformedURLException, ParseException {

        LoginPage login_obj = new LoginPage(driver);
        String url = baseUrl;
        Assert.assertNotNull(url);
        driver.get(baseUrl);
        login_obj.setUserName(userName);
        login_obj.setPassword(password);
        login_obj.login();
        ManagerHome home = new ManagerHome(driver);
        home.click_New_Customer();

        AddNewCustomer newCustomer = new AddNewCustomer(driver);
//        fill_customer(newCustomer,)

        Thread.sleep(3000);
    }

    private void fill_customer(AddNewCustomer newCustomer,Object[][] objects) throws ParseException {

        newCustomer.fill_customer_name("Mohit");
        newCustomer.click_male();
        newCustomer.selectDate("01022007");
    }


}
