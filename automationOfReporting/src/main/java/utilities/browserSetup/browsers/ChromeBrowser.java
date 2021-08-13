package utilities.browserSetup.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReadPropertyFiles;
import utilities.browserSetup.BrowserConfiguration;

import java.util.concurrent.TimeUnit;

public class ChromeBrowser extends BrowserConfiguration {

    private String mode;
    private ChromeOptions options;
    private WebDriver driver;

    @Override
    public void readBrowserProperties() {
        mode = ReadPropertyFiles.getValue("chromeProperties", "mode");
    }

    @Override
    public void setTheProperties() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--" + mode);
    }

    @Override
    public WebDriver returnTheDriver() {
        readBrowserProperties();
        setTheProperties();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
