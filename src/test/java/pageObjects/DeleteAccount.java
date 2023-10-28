package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccount {
    @FindBy(xpath = "//input[@name='accountno']")
    WebElement account_no;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submit_btn;
    @FindBy(xpath = "//input[@name='res']")
    WebElement reset_btn;
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement home_btn;
    public DeleteAccount(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void setaccount_no(String str){
        account_no.sendKeys(str);
    }
    public void setSubmit_btn(){
        submit_btn.click();
    }
    public void setReset_btn(){
        reset_btn.click();
    }
    public void click_home(){home_btn.click();}
}
