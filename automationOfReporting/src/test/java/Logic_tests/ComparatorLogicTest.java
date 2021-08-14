package Logic_tests;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service_layer_automation.data_driving_classes.SetQueryParamsForCurrentTemp;
import utilities.ReadPropertyFiles;

public class ComparatorLogicTest extends BaseTest{

    private int temperatureFromUI;
    private int temperatureFromAPI;

    @Test(dataProvider = "getData")
    public void comparator(String place,String key,int variance){

        temperatureFromUI=Integer.parseInt((String)actions.returnInfo(place).get(0));

        setQueryParams =new SetQueryParamsForCurrentTemp.QueryParamBuilder()
                .q(place)
                .appid(key)
                .build();
        temperatureFromAPI=getCurrentWeather.currentTemperature(setQueryParams);

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
