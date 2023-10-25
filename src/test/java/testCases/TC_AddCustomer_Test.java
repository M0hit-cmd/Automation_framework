package testCases;

import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AddNewCustomer;
import pageObjects.LoginPage;
import pageObjects.ManagerHome;

import java.text.ParseException;

public class TC_AddCustomer_Test extends Base_Class {
    @Test(dataProvider = "customer_data")
    public void addNewCustomer(String[] objects) throws InterruptedException, ParseException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(userName);
        lp.setPassword(password);
        lp.login();
        ManagerHome managerHome=new ManagerHome(driver);
        Assert.assertTrue(managerHome.welcome_message());
        managerHome.click_New_Customer();
        AddNewCustomer customer=new AddNewCustomer(driver);
        customer.fill_customer(objects);
        Thread.sleep(5000);
        customer.setSubmit();
        Thread.sleep(5000);
       if (driver.getPageSource().contains("Customer Registered Successfully"))
       {
           Assert.assertTrue(true);
       }
       else
       {
           Assert.fail();
       }
    }
    @DataProvider(name="customer_data")
    public String[][] customer_data_provider(){
        return new String[][]{{"Mohit","Male","06101998","Address of Mohit","Faridabad","Haryana","121004","8888688888",randomestring()+"@gmail.com","ABC@121004"},{"Rohit Sharma","Male","07022000","Address of Rohit","Mumbai","Maharashtra","100902","9894820999",randomestring()+"@gmail.com","ABC@121004"},{"Radha","Female","01012001","Address of Radha","New Delhi","Delhi","121005","8989838582",randomestring()+"@gmail.com","ABC@121004"}};
    }
    public String randomestring(){
        return RandomString.make(8);
    }

}
