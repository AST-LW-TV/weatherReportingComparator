package ui_testing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.browserSetup.BrowserFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriver driver= BrowserFactory.getDriver();
        driver.get("https://www.google.com");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
