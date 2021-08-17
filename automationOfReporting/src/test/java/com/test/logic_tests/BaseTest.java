package com.test.logic_tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import service_layer_automation.get_requests.GetCurrentWeather;
import ui_automation.commons.WebActions;
import utilities.ReadPropertyFiles;
import utilities.VideoRecorder;
import utilities.browserSetup.BrowserFactory;

@Listeners(common.Listeners.class)

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebActions actions;
    protected SetQueryParamsForCurrentTemp setQueryParams;
    protected GetCurrentWeather getCurrentWeather;

    protected void miniFactory(String place, String key) {
        setQueryParams = new SetQueryParamsForCurrentTemp.QueryParamBuilder()
                .q(place)
                .appid(key)
                .build();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) {
        VideoRecorder.startRecording();
        driver = BrowserFactory.getDriver();
        driver.get(ReadPropertyFiles.getValue("urlProperties", "url"));
        context.setAttribute("WebDriverInstance", driver);
        actions = new WebActions(driver);

        getCurrentWeather = new GetCurrentWeather();
    }

    @DataProvider
    public Object[][] getData() {
        int variance = 3;
        String key = ReadPropertyFiles.getValue("stagingKeys", "apiKey");
        String place = ReadPropertyFiles.getValue("commonFile", "place");
        return new Object[][]{
                {place, key, variance}
        };
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        VideoRecorder.stopRecording();
    }
}