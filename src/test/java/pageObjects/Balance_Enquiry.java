package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Read_details;

public class Balance_Enquiry {
    @FindBy(xpath = "//input[@name='accountno']")
    WebElement account_no;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submit_btn;
    public Balance_Enquiry(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    public void submit_Account_no()
    {
        Read_details rd=new Read_details();
        account_no.sendKeys(rd.getAccount_no());
        submit_btn.click();
    }
}
