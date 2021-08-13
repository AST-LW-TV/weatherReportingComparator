package utilities.browserSetup.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.ReadPropertyFiles;
import utilities.browserSetup.BrowserConfiguration;

import java.util.concurrent.TimeUnit;

public class FirefoxBrowser extends BrowserConfiguration {

    private String mode;
    private FirefoxOptions options;
    private WebDriver driver;

    @Override
    public void readBrowserProperties() {
        mode = ReadPropertyFiles.getValue("firefoxProperties", "mode");
    }

    @Override
    public void setTheProperties() {
        WebDriverManager.firefoxdriver().setup();
        options = new FirefoxOptions();
        options.addArguments("--" + mode);
    }

    @Override
    public WebDriver returnTheDriver() {
        readBrowserProperties();
        setTheProperties();
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
