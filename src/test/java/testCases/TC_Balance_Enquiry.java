package testCases;

import org.testng.annotations.Test;
import pageObjects.Balance_Enquiry;

public class TC_Balance_Enquiry extends Base_Class {
    @Test
    public void balance_enquiry(){
        Balance_Enquiry balanceEnquiry=new Balance_Enquiry(driver);
        balanceEnquiry.submit_Account_no();
    }

}
