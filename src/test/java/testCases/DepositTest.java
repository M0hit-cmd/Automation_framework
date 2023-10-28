package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Deposit;
import utils.Read_details;

import java.io.IOException;
import java.time.Duration;

public class DepositTest extends Base_Class{
    @Test
    public void deposit_test() throws IOException {
        WebDriverWait driverWait=new WebDriverWait(driver, Duration.ofSeconds(6));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='DepositInput.php']"))).click();
        Deposit dpt=new Deposit(driver);
        Read_details rd=new Read_details();
        dpt.deposit_func("2000","deposits");
        if(isAlertPresent())
        {
            if(driver.switchTo().alert().getText().equalsIgnoreCase("Customer does not exist!!"))
            {
                logger.info("Customer does not exist!!");
                Assert.fail();
            }
            else
            {
                Assert.assertTrue(true);
            }
        }
    }
}
