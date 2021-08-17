package utilities.browserSetup.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.browserSetup.BrowserConfiguration;

import java.util.concurrent.TimeUnit;

public class SafariBrowser extends BrowserConfiguration {

    private WebDriver driver;

    @Override
    public void readBrowserProperties() {
    }

    @Override
    public void setTheProperties() {
    }

    @Override
    public WebDriver returnTheDriver() {
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
