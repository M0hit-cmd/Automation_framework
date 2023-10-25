package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHome {
    WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'New Customer')]")
    WebElement New_Customer;
    @FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
    WebElement Edit_Customer;
    @FindBy(xpath = "//a[contains(text(),'Delete Customer')]")
    WebElement Delete_Customer;
    @FindBy(xpath = "//a[contains(text(),'New Account')]")
    WebElement New_Account;
    @FindBy(xpath = "//a[contains(text(),'Edit Account')]")
    WebElement Edit_Account;
    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    WebElement Delete_Account;

    @FindBy(xpath = "//a[contains(text(),'Deposit')]")
    WebElement Deposit;
    @FindBy(xpath = "//a[contains(text(),'Withdrawal')]")
    WebElement Withdrawal;

    @FindBy(xpath = "//a[contains(text(),'Fund Transfer')]")
    WebElement Fund_Transfer;

    @FindBy(xpath = "//a[contains(text(),'Change Password')]")
    WebElement Change_Password;
    @FindBy(xpath = "//a[contains(text(),'Balance Enquiry')]")
    WebElement Balance_Enquiry;
    @FindBy(xpath = "//a[contains(text(),'Mini Statement')]")
    WebElement Mini_Statement;

    @FindBy(xpath = "//a[contains(text(),'Customised Statement')]")
    WebElement Customised_Statement;
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement Log_out;

    public ManagerHome(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void click_New_Customer(){
        New_Customer.click();
    }

    public void click_Edit_Customer(){
        Edit_Customer.click();
    }
    public void click_Delete_Customer(){
        Delete_Customer.click();
    }
    public void click_New_Account(){
        New_Account.click();
    }
    public void click_Edit_Account(){
        Edit_Account.click();
    }
    public void click_Delete_Account(){
        Delete_Account.click();
    }public void click_Deposit(){
        Deposit.click();
    }
    public void click_Withdrawal(){
        Withdrawal.click();
    }
    public void click_Fund_Transfer(){
        Fund_Transfer.click();
    }
    public void click_Change_Password(){
        Change_Password.click();
    }
    public void click_Balance_Enquiry(){
        Balance_Enquiry.click();
    }
    public void click_Mini_Statement(){
        Mini_Statement.click();
    }
    public void click_Customised_Statement(){
        Customised_Statement.click();
    }
    public void click_Log_out(){
        Log_out.click();
    }



}