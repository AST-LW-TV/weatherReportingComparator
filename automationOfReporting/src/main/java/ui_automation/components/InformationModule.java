package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExplicitDriverWaits;

import java.util.ArrayList;
import java.util.List;

public class InformationModule extends AbstractComponent {

    private List<String> info;
    private String airQuality;
    private String windSpeed;

    @FindBy(css = ".cur-con-weather-card__body .temp")
    WebElement temperature;

    @FindBy(css = ".cur-con-weather-card__panel.details-container>div>span[class='value']")
    List<WebElement> infoAboutWeather;

    public InformationModule(WebDriver driver) {
        super(driver);
    }

    private void helper(int startIndex) {
        for (int i = startIndex; i < infoAboutWeather.size(); i++)
            info.add(infoAboutWeather.get(i).getText());
    }

    public void getInfo() {
        infoAboutWeather = new ArrayList<>();
        if (infoAboutWeather.size() == 4)
            helper(1);
        else
            helper(0);
    }

    public String getCurrentTemperature() {
        ExplicitDriverWaits.visibility(driver, temperature);
        return temperature
                .getText()
                .trim(); // index 0 has current temperature
    }

    public String getAirQuality() {
        airQuality = info.get(0);
        return airQuality;
    }

    public String getWindSpeed() {
        windSpeed = info.get(1);
        return windSpeed;
    }
}