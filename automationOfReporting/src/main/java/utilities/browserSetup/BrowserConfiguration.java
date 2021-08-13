package utilities.browserSetup;

import org.openqa.selenium.WebDriver;

public abstract class BrowserConfiguration {

    public abstract void readBrowserProperties();

    public abstract void setTheProperties();

    public abstract WebDriver returnTheDriver();
}
