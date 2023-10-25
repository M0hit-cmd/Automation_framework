package testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_DDT_Login extends Base_Class {
    @Test(dataProvider = "LoginData" )
    public void ddtLogin(String[] loginData){
        String user=loginData[0];
        String pass=loginData[1];
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(user);
        logger.info("username entered");
        lp.setPassword(pass);
        logger.info("password entered");
        lp.login();
        if(isAlertPresent()){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.fail();
            logger.warning("Login failed");
        }
        else{
            Assert.assertTrue(true);
            lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();

        }

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
    @DataProvider(name="LoginData")
    String[][] LoginData(){
        return new String[][]{{"mngr534116","hUmYqyv"},{"mngr432432","hksjdhkj"}};
    }
}
