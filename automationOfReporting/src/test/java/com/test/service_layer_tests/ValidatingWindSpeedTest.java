package com.test.service_layer_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import service_layer_automation.get_requests.GetCurrentWeather;
import utilities.ReadPropertyFiles;
import utilities.jsonParserFunctions.JsonBlobType3;

public class ValidatingWindSpeedTest {

    private JsonBlobType3 js;
    private SetQueryParamsForCurrentTemp setQueryParams;
    private GetCurrentWeather getCurrentWeather;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        getCurrentWeather = new GetCurrentWeather();
    }

    @Test(dataProvider = "getData", groups = {"api_regression_tests"})
    @Description("This test checks the speed of the wind from API call")
    @Severity(SeverityLevel.NORMAL)
    public void checkingWindSpeed(String place, String key) {
        setQueryParams = new SetQueryParamsForCurrentTemp.QueryParamBuilder()
                .q(place)
                .appid(key)
                .build();
        Assert.assertTrue(getCurrentWeather.currentWindSpeed(setQueryParams) < 15);
    }

    @DataProvider
    public Object[][] getData() {
        String key = ReadPropertyFiles.getValue("stagingKeys", "apiKey");
        js = new JsonBlobType3("queryParam1");
        JSONObject object = (JSONObject) js.jsonParserBlobType("");
        return new Object[][]{
                {object.get("q"), key}
        };
    }
}