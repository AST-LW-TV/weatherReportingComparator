package comparator_logic.actions;

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

    public WebActions(WebDriver driver){
        this.driver=driver;
        homePage=new AccuWeatherHomePage(driver);
        resultPage=new AccuWeatherResultsPage(driver);
    }

    private void convertTemperatureToInt(){
        int size=temperature.length();
        temperature=temperature.substring(0,size-(size-2));
    }

    private void convertSentenceToInt(){
        String[] array=windSpeed.split(" ");
        windSpeed=array[1];
    }

    private void navigateToResultsPage(String place){
        homePage.getPolicyComponent().clickOnPolicy();
        homePage.getSearchComponent().selectFirstOptionFromDropDown(place);
    }
    private void stayOnSamePage(String place){
        resultPage.getSearchComponent().selectPlaceInResultPlace(place);
    }

    private void performingFactoryMethods(){
        temperature=resultPage.getInformationModule().getCurrentTemperature();
        airQuality=resultPage.getInformationModule().getAirQuality();
        windSpeed=resultPage.getInformationModule().getWindSpeed();
        convertTemperatureToInt();
        convertSentenceToInt();
    }

    // gives the current temperature - at index 0...
    public List<Object> returnInfo(String place,int count){
        List<Object> informationList=new ArrayList<>();
        if(count<=1)
            navigateToResultsPage(place);
        else // here use the search component present in result page
            stayOnSamePage(place);
        performingFactoryMethods();
        informationList.add(temperature);
        informationList.add(airQuality);
        informationList.add(windSpeed);
        return informationList;
    }

}
