package com.test.ui_tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_automation.components.SearchComponent;
import utilities.jsonParserFunctions.JsonBlobType1;

@Listeners(common.Listeners.class)

public class SearchBarSuggestionsTest extends BaseTest {

    private SearchComponent searchComponent;
    private JsonBlobType1 js;

    @Test(dataProvider = "getData", groups = {"ui_regression_tests", "second_priority"}, dependsOnGroups = {"first_priority"})
    @Description("This test validates threshold number of suggestions are suggested or not")
    @Severity(SeverityLevel.NORMAL)
    public void searchResults(String place) {
        searchComponent = new SearchComponent(driver);
        int numberOfSearchSuggestions;
        numberOfSearchSuggestions = searchComponent.getNumberOfPlaceSuggestions(place);
        Assert.assertTrue(numberOfSearchSuggestions <= 5);
    }

    @DataProvider
    public Object[][] getData() {
        js = new JsonBlobType1("places");
        JSONArray array = (JSONArray) js.jsonParserBlobType();
        int totalPlaces = array.size();
        Object[][] data = new Object[totalPlaces][1]; // 1D object
        for (int i = 0; i < totalPlaces; i++)
            data[i][0] = array.get(i);
        return data;
    }
}