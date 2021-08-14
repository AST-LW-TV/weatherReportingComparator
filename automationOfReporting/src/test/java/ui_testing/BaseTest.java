package ui_testing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ReadPropertyFiles;
import utilities.browserSetup.BrowserFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver= BrowserFactory.getDriver();
        driver.get(ReadPropertyFiles.getValue("urlProperties","url"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}