package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Read_details;

import java.io.*;
import java.util.Properties;

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
    public Deposit(WebDriver driver){
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
    public void deposit_func( String amount,String desc) throws IOException {
        Read_details rd=new Read_details();
        setAmount(amount);
        setAccount_no(rd.getAccount_no());
        setDesc(desc);
        setSubmit_btn();
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties"));
        OutputStream out = new FileOutputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties");
        prop.setProperty("deposit_amount",amount);
        prop.store(out,"deposit amount");

    }
}
