package com.test.logic_tests;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import utilities.ReadPropertyFiles;

public class ComparatorLogicTest extends BaseTest{

    private int temperatureFromUI;
    private int temperatureFromAPI;

    private int getTemperatureFromUI(String place){
        return Integer.parseInt(actions.returnInfo(place));
    }

    private int getTemperatureFromAPI(String place,String key){
        setQueryParams =new SetQueryParamsForCurrentTemp.QueryParamBuilder()
                .q(place)
                .appid(key)
                .build();
        return getCurrentWeather.currentTemperature(setQueryParams);
    }

    @Test(dataProvider = "getData",groups={"comparator"})
    public void comparator(String place,String key,int variance){
        temperatureFromUI=getTemperatureFromUI(place);
        temperatureFromAPI=getTemperatureFromAPI(place,key);
        Assert.assertTrue(Math.abs(temperatureFromAPI-temperatureFromUI)<=variance);
    }

    @DataProvider
    public Object[][] getData(){
        int variance=3;
        String key=ReadPropertyFiles.getValue("stagingKeys","apiKey");
        String place= ReadPropertyFiles.getValue("commonFile","place");
        return new Object[][]{
                {place,key,variance}
        };
    }

}
