package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.Properties;

public class Customer_Register_Success {
    WebDriver driver;
    @FindBy(xpath = "//td[contains(text(),'Customer ID')]/following-sibling::td")
    WebElement customer_id;
    @FindBy(xpath = "//tr/td[contains(text(),'Customer Name')]/following-sibling::td")
    WebElement customer_name;
    @FindBy(xpath = "//tr/td[contains(text(),'City')]/following-sibling::td")
    WebElement customer_city;
    public Customer_Register_Success(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void store() throws IOException {
        Properties prop=new Properties();
        prop.load(new FileInputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties"));
        String key=customer_name.getText()+customer_city.getText();
        OutputStream out=new FileOutputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties");
        prop.setProperty(key,customer_id.getText());
        prop.store(out,"Customer added");
    }
}
