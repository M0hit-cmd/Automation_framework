package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid {
    public static WebDriver initializeBrowser(String browserName) throws MalformedURLException, MalformedURLException {
        WebDriver driver;
        DesiredCapabilities dc =new DesiredCapabilities();

        switch (browserName) {
            case "firefox" -> dc.setBrowserName("firefox");
            case "edge" -> dc.setBrowserName("MicrosoftEdge");
            case "ie" -> dc.setBrowserName("internet explorer");
            case "opera" -> dc.setBrowserName("opera");
            case "safari" -> dc.setBrowserName("safari");
            default -> dc.setBrowserName("chrome");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);

        return driver;
    }

}
