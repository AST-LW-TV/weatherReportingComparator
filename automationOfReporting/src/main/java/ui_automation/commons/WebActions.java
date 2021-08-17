package ui_automation.commons;

import org.openqa.selenium.WebDriver;
import ui_automation.pages.AccuWeatherHomePage;
import ui_automation.pages.AccuWeatherResultsPage;

import java.util.ArrayList;
import java.util.List;

/*
    WebActions class is responsible for getting the required details from UI
 */

public class WebActions {

    private WebDriver driver;
    private AccuWeatherHomePage homePage;
    private AccuWeatherResultsPage resultPage;

    private String temperature;
    private String airQuality;
    private String windSpeed;
    List<Object> informationList = new ArrayList<>();
    private boolean flag = false;

    public WebActions(WebDriver driver) {
        this.driver = driver;
        homePage = new AccuWeatherHomePage(driver);
        resultPage = new AccuWeatherResultsPage(driver);
    }

    // 24C -> 24
    private void convertTemperatureToInt() {
        int size = temperature.length();
        temperature = temperature.substring(0, size - (size - 2));
    }

    // SW 22 Km/hr -> ["SW", "22", "Km/hr"]
    private void convertSentence() {
        String[] array = windSpeed.split(" ");
        windSpeed = array[1];
    }

    // navigating from home page to results page
    private void navigateToResultsPage(String place) {
        homePage.getPolicyComponent().clickOnPolicy();
        homePage.getSearchComponent().selectFirstOptionFromDropDown(place);
    }

    // searching the place using the input field present in the result page
    private void stayOnSamePage(String place) {
        resultPage.getSearchComponent().selectPlaceInResultPlace(place);
    }

    // helper method performing combination of operations
    private void performingFactoryMethods(boolean flag) {
        resultPage.getInformationModule().getInfo();
        temperature = resultPage.getInformationModule().getCurrentTemperature();
        windSpeed = resultPage.getInformationModule().getWindSpeed();
        convertTemperatureToInt();
        convertSentence();
        if (!flag) {
            airQuality = resultPage.getInformationModule().getAirQuality();
        }
    }

    // helper method to eliminate the duplicate code
    private void miniFactory(boolean flag) {
        performingFactoryMethods(flag);
        if (!flag) {
            informationList.add(temperature);
            informationList.add(airQuality);
            informationList.add(windSpeed);
        }
    }

    // Polymorphism concept -

    // used to test the input field in the result page
    public List<Object> returnInfo(String place, int count) {
        if (count <= 1)
            navigateToResultsPage(place);
        else
            // here using the search component present in result page
            stayOnSamePage(place);
        miniFactory(flag);
        return informationList;
    }

    // used to get temperature and pressure from the UI
    public List<String> returnInfo(String place) {
        List<String> temperatureAndPressure = new ArrayList<>();
        flag = true;
        navigateToResultsPage(place);
        miniFactory(flag);
        temperatureAndPressure.add(temperature);
        temperatureAndPressure.add(windSpeed);
        return temperatureAndPressure;
    }
}