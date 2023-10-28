package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DeleteCustomer;
import pageObjects.ManagerHome;
import resources.StaticDataProvider;
import utils.Read_details;

import java.time.Duration;

public class TC_DeleteCustomer extends Base_Class {

    @Test()
    public void delete_customer() throws InterruptedException {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().refresh();
        Thread.sleep(5000);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'DeleteCustomerInput.php')]"))).click();
        Read_details rd = new Read_details();
        DeleteCustomer dc = new DeleteCustomer(driver);
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cusid']"))).click();
        dc.setCust_id(rd.getCust_id());
        dc.setSubmit_btn();
        if (isAlertPresent()) {
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
            logger.info("Customer deleted successfully");
            Assert.assertTrue(true);
        }
    }
}