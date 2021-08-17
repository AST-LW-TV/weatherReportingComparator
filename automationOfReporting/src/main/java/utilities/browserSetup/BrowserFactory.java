package utilities.browserSetup;

import org.openqa.selenium.WebDriver;
import utilities.ReadPropertyFiles;
import utilities.browserSetup.browsers.ChromeBrowser;
import utilities.browserSetup.browsers.FirefoxBrowser;

/*
    Factory Pattern
 */

public class BrowserFactory {

    private static String browserName;

    public static WebDriver getDriver() {
        browserName = ReadPropertyFiles.getValue("browserProperties", "browser");
        if (browserName.equalsIgnoreCase("chrome"))
            return new ChromeBrowser().returnTheDriver();
        else if (browserName.equalsIgnoreCase("firefox"))
            return new FirefoxBrowser().returnTheDriver();
        else
            return null;
    }
}
