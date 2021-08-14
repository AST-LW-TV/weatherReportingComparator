package ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ReadPropertyFiles;
import utilities.browserSetup.BrowserFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = BrowserFactory.getDriver();
        driver.get(ReadPropertyFiles.getValue("urlProperties", "url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}