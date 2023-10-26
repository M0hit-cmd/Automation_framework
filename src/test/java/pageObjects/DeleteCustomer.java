package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {
    @FindBy(xpath = "//input[@name='cusid']")
    WebElement cust_id;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submit_btn;
    @FindBy(xpath = "//input[@name='res']")
    WebElement reset_btn;
    public DeleteCustomer(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void setCust_id(String str){
        cust_id.sendKeys(str);
    }
    public void setSubmit_btn(){
        submit_btn.click();
    }
    public void setReset_btn(){
        reset_btn.click();
    }
}
