package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.IDataProviderAnnotation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewCustomer {
    WebDriver driver;
    @FindBy(xpath = "//input[@name='name']")
    WebElement customer_Name;

    @FindBy(xpath = "//input[@value='f']")
    WebElement female_radio;
    @FindBy(xpath = "//input[@value='m']")
    WebElement male_radio;
    @FindBy(xpath = "//input[@type='date']")
    WebElement date_ele;
    @FindBy(xpath = "//textarea[@name='addr']")
    WebElement address;
    @FindBy(xpath = "//input[@name='city']")
    WebElement city;
    @FindBy(xpath = "//input[@name='state']")
    WebElement state;
    @FindBy(xpath = "//input[@name='pinno']")
    WebElement pin;
    @FindBy(xpath = "//input[@name='telephoneno']")
    WebElement phone_no;
    @FindBy(xpath = "//input[@name='emailid']")
    WebElement email;
    @FindBy(xpath = "//input[@name='password']")
    WebElement pass;

    public  AddNewCustomer(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void fill_customer_name(String str){
        customer_Name.sendKeys(str);
    }
    public void click_female(){
        female_radio.click();
    }
    public void click_male(){
        male_radio.click();
    }
    public void selectDate(String str) throws ParseException {
//        String str="01012006";
        String year=str.substring(4);
        String ddmm=str.subSequence(0,4).toString();
        date_ele.clear();
        date_ele.sendKeys(ddmm);
        date_ele.sendKeys(Keys.TAB);
        date_ele.sendKeys(year);
    }

}