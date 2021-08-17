package com.test.logic_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.testng.annotations.Test;
import service_layer_automation.common.KmhrToMhr;

public class WindSpeedComparatorLogicTest extends BaseTest {

    private int windSpeedFromUI;
    private int windSpeedFromAPI;

    private int getWindSpeedFromAPI(String place, String key) {
        miniFactory(place, key);
        return (int) getCurrentWeather.currentWindSpeed(setQueryParams);
    }

    private int getWindSpeedFromUI(String place) {
        return Integer.parseInt(actions.returnInfo(place).get(1));
    }

    @Test(dataProvider = "getData", groups = {"comparator"})
    @Description("This test checks whether wind speed from UI and API is within the range")
    @Severity(SeverityLevel.NORMAL)
    public void comparator(String place, String key, int variance) {
        windSpeedFromUI = getWindSpeedFromUI(place);
        windSpeedFromUI = KmhrToMhr.conversion(windSpeedFromUI);
        windSpeedFromAPI = getWindSpeedFromAPI(place, key);
        Assert.assertTrue(Math.abs(windSpeedFromUI - windSpeedFromAPI) <= variance);
    }
}