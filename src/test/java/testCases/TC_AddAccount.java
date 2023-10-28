package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Account_Register_Success;
import pageObjects.AddNewAccount;
import utils.Read_details;

import java.io.IOException;
import java.time.Duration;

public class TC_AddAccount extends Base_Class {
    @Test
    public void addAccount() throws InterruptedException, IOException {

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='addAccount.php']"))).click();
        AddNewAccount newAccount = new AddNewAccount(driver);
        Read_details rd = new Read_details();
        newAccount.fillDefault(rd.getCust_id(), "3000", "savings");
        Thread.sleep(2000);
        if (isAlertPresent()) {
            logger.info("Account could not be created");
            Assert.fail();
        }
        Account_Register_Success accountRegisterSuccess = new Account_Register_Success(driver);

        logger.info("Sucessfully Created account");
        Assert.assertTrue(true);
        accountRegisterSuccess.store();
        Thread.sleep(3000);
    }

    }

