package ui_tests;

import ui_automation.commons.WebActions;
import org.json.simple.JSONArray;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.jsonParserFunctions.JsonBlobType2;

public class CheckWindSpeedTest extends BaseTest {

    private WebActions actions;
    private JsonBlobType2 js;
    private int count=0;

    @Test(dataProvider = "getData",groups={"ui_regression_tests","third_priority"},dependsOnGroups = "second_priority")
    public void windSpeedValidation(String place){
        int size=place.length()-(place.length()-3);
        place=place.substring(0,size);
        count+=1;
        actions=new WebActions(driver);
        Assert.assertTrue(
                Integer.parseInt((String)actions.returnInfo(place,count).get(2))<15
        );
    }

    @DataProvider
    public Object[][] getData(){
        js=new JsonBlobType2("placesInMain");
        JSONArray array=(JSONArray) js.jsonParserBlobType();
        int totalPlaces=array.size();
        Object[][] data=new Object[totalPlaces][1];
        for(int i=0;i<totalPlaces;i++)
            data[i][0]=array.get(i);
        return data;
    }

}
