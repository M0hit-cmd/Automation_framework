package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Account_Register_Success {
    WebDriver driver;
    @FindBy(xpath = "//td[contains(text(),'Account ID')]/following-sibling::td")
    WebElement account_id;
    @FindBy(xpath = "//tr/td[contains(text(),'Current Amount')]/following-sibling::td")
    WebElement current_amount;
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    public Account_Register_Success(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    public void click_continue() {
        continueBtn.click();
    }

    public void get_amount() {
        current_amount.getText();
    }

    public void store() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties"));
        OutputStream out = new FileOutputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties");
        prop.setProperty("account_id", account_id.getText());
        prop.setProperty("intial_amount", current_amount.getText());
        prop.store(out, "Account added");
    }
}
