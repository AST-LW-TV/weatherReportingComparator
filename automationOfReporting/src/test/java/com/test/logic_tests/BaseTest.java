package com.test.logic_tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import service_layer_automation.get_requests.GetCurrentWeather;
import ui_automation.commons.WebActions;
import utilities.ReadPropertyFiles;
import utilities.browserSetup.BrowserFactory;

@Listeners(common.Listeners.class)

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebActions actions;
    protected SetQueryParamsForCurrentTemp setQueryParams;
    protected GetCurrentWeather getCurrentWeather;

    @BeforeTest(alwaysRun = true)
    public void setUp(ITestContext context) {
        driver = BrowserFactory.getDriver();
        driver.get(ReadPropertyFiles.getValue("urlProperties", "url"));
        context.setAttribute("WebDriverInstance",driver);
        actions = new WebActions(driver);

        getCurrentWeather = new GetCurrentWeather();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
