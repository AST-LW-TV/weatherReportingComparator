package ui_testing.miscellaneous_tests;

import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui_automation.components.SearchComponent;
import ui_testing.BaseTest;
import utilities.jsonParserFunctions.JsonBlobType1;

public class SearchBarSuggestions extends BaseTest {

    private SearchComponent searchComponent;
    private JsonBlobType1 js;

    @Test(dataProvider="getData")
    public void searchResults(String place){
        searchComponent=new SearchComponent(driver);
        int numberOfSearchSuggestions;
        numberOfSearchSuggestions=searchComponent.getNumberOfPlaceSuggestions(place);
        System.out.println(numberOfSearchSuggestions);
        Assert.assertTrue(numberOfSearchSuggestions<=5);
    }

    @DataProvider
    public Object[][] getData(){
        js=new JsonBlobType1();
        JSONArray array=(JSONArray) js.jsonParserBlobType();
        int totalPlaces=array.size();
        Object[][] data=new Object[totalPlaces][1]; // 1D object
        for(int i=0;i<totalPlaces;i++)
            data[i][0]=array.get(i);
        return data;
    }
}
