package Logic_tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import service_layer_automation.get_requests.GetCurrentWeather;
import ui_automation.commons.WebActions;
import utilities.ReadPropertyFiles;
import utilities.browserSetup.BrowserFactory;

public class BaseTest {

    protected WebDriver driver;
    protected WebActions actions;
    protected SetQueryParamsForCurrentTemp setQueryParams;
    protected GetCurrentWeather getCurrentWeather;

    @BeforeTest
    public void setUp(){
        driver= BrowserFactory.getDriver();
        driver.get(ReadPropertyFiles.getValue("urlProperties","url"));
        actions=new WebActions(driver);

        getCurrentWeather=new GetCurrentWeather();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
