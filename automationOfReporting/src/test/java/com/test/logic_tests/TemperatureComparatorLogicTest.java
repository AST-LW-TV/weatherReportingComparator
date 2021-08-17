package com.test.logic_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TemperatureComparatorLogicTest extends BaseTest {

    private int temperatureFromUI;
    private int temperatureFromAPI;

    private int getTemperatureFromUI(String place) {
        return Integer.parseInt(actions.returnInfo(place).get(0));
    }

    private int getTemperatureFromAPI(String place, String key) {
        miniFactory(place, key);
        return getCurrentWeather.currentTemperature(setQueryParams);
    }

    @Test(dataProvider = "getData", groups = {"comparator"})
    @Description("This test checks whether temperature from UI and API is within the range")
    @Severity(SeverityLevel.CRITICAL)
    public void comparator(String place, String key, int variance) {
        temperatureFromUI = getTemperatureFromUI(place);
        temperatureFromAPI = getTemperatureFromAPI(place, key);
        Assert.assertTrue(Math.abs(temperatureFromAPI - temperatureFromUI) <= variance);
    }
}