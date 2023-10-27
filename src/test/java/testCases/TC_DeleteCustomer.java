package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DeleteCustomer;
import resources.StaticDataProvider;
import utils.Read_details;

public class TC_DeleteCustomer extends  Base_Class{
    Read_details rd=new Read_details();
    @Test(dataProvider = "default_customer_data",dataProviderClass = StaticDataProvider.class)
    public void delete_customer(String[]str){
        DeleteCustomer dc=new DeleteCustomer(driver);
        dc.setCust_id(rd.getCust_id());
        dc.setSubmit_btn();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Assert.fail();
        logger.warning("Login failed");
        }
    }
}
