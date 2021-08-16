package ui_automation.commons;

import org.openqa.selenium.WebDriver;
import ui_automation.pages.AccuWeatherHomePage;
import ui_automation.pages.AccuWeatherResultsPage;

import java.util.ArrayList;
import java.util.List;

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

    private void convertTemperatureToInt() {
        int size = temperature.length();
        temperature = temperature.substring(0, size - (size - 2));
    }

    private void convertSentenceToInt() {
        String[] array = windSpeed.split(" ");
        windSpeed = array[1];
    }

    private void navigateToResultsPage(String place) {
        homePage.getPolicyComponent().clickOnPolicy();
        homePage.getSearchComponent().selectFirstOptionFromDropDown(place);
    }

    private void stayOnSamePage(String place) {
        resultPage.getSearchComponent().selectPlaceInResultPlace(place);
    }

    private void performingFactoryMethods(boolean flag) {
        temperature = resultPage.getInformationModule().getCurrentTemperature();
        convertTemperatureToInt();
        if (!flag) {
            airQuality = resultPage.getInformationModule().getAirQuality();
            windSpeed = resultPage.getInformationModule().getWindSpeed();
            convertSentenceToInt();
        }
    }

    private void miniFactory(boolean flag) {
        performingFactoryMethods(flag);
        if (!flag) {
            informationList.add(temperature);
            informationList.add(airQuality);
            informationList.add(windSpeed);
        }
    }

    // gives the current temperature - at index 0...
    public List<Object> returnInfo(String place, int count) {
        if (count <= 1)
            navigateToResultsPage(place);
        else // here use the search component present in result page
            stayOnSamePage(place);
        miniFactory(flag);
        return informationList;
    }

    public String returnInfo(String place) {
        flag = true;
        navigateToResultsPage(place);
        miniFactory(flag);
        return temperature;
    }
}