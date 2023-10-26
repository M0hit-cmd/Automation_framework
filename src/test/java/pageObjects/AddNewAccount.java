package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccount {
    @FindBy(xpath = "//input[@name='cusid']")
    WebElement cust_id;
    @FindBy(xpath = "//select[@name='selaccount']")
    WebElement account_type;
    @FindBy(xpath = "//input[@name='inideposit']")
    WebElement amount;
    @FindBy(xpath = "//input[@name='button2']")
    WebElement submit_btn;
    @FindBy(xpath = "//input[@name='reset']")
    WebElement reset_btn;

    public  AddNewAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void fill_cust_id(String str) {
        cust_id.sendKeys(str);

    }

    public void fill_account_type(String str) {
        Select type = new Select(account_type);

        if (str.equalsIgnoreCase("savings")) {
            type.selectByIndex(0);
        } else {
            type.selectByIndex(1);
        }

    }

    public void fill_amount(String amount) {
        this.amount.sendKeys(amount);

    }

    public void setSubmit_btn() {
        submit_btn.click();
    }

    public void setReset_btn() {
        reset_btn.click();
    }

}
