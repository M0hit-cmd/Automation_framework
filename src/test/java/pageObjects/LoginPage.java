package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@name='uid']")
    WebElement txtUserName;
    @FindBy(xpath = "//*[@name='password']")
    WebElement pass;

    @FindBy(xpath = "//*[@name='btnLogin']")
    WebElement btnLogin;

    public void setUserName(String userName){
        txtUserName.sendKeys(userName);
    }
    public void setPassword(String password)
    {
        pass.sendKeys(password);
    }
    public void login()
    {
        btnLogin.click();
    }
}
