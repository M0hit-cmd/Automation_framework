package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deposit {
    @FindBy(xpath = "//input[@name='accountno']")
    WebElement account_no;
    @FindBy(xpath = "//input[@name='ammount']")
    WebElement amount;
    @FindBy(xpath = "//input[@name='desc']")
    WebElement desc;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submit_btn;
    @FindBy(xpath = "//input[@name='res']")
    WebElement reset_btn;
    public Deposit(WebElement driver){
        PageFactory.initElements(driver,this);
    }
    public void setAccount_no(String str){
        account_no.sendKeys(str);
    }
    public void setAmount(String str){
        amount.sendKeys(str);
    }
    public void setDesc(String str){
        desc.sendKeys(str);
    }
    public void setSubmit_btn(){
        submit_btn.click();
    }
    public void setReset_btn(){
        reset_btn.click();
    }
}
