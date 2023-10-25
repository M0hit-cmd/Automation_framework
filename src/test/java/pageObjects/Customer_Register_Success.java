package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Customer_Register_Success {
    WebDriver driver;
    @FindBy(xpath = "//td[contains(text(),'Customer ID')]/following-sibling::td")
    WebElement customer_id;
    public Customer_Register_Success(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void store(int count) throws IOException {
        Properties prop=new Properties();

        String key="Customer No. "+count;
        count++;
        OutputStream out=new FileOutputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties");
        prop.setProperty(key,customer_id.getText());
        prop.store(out,"Customer added");
    }
}
