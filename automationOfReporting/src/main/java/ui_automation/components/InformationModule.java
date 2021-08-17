package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExplicitDriverWaits;

import java.util.ArrayList;
import java.util.List;

// Informational module in the results page which has weather info about the desired place

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

    // HTML page is dynamic and lack of id locator
    // if WebElement size - 4 [RealFeelShade, AirQuality, Wind, Wind Gusts]
    // if WebElement size - 3 [AirQuality, Wind, Wind Gusts]
    // choosing the info dynamically
    public void getInfo() {
        info = new ArrayList<>();
        if (infoAboutWeather.size() == 4)
            helper(1);
        else
            helper(0);
    }

    /**
     * Gets the current temperature
     *
     * @return temperature - String format
     */
    public String getCurrentTemperature() {
        ExplicitDriverWaits.visibility(driver, temperature);
        return temperature
                .getText()
                .trim();
    }

    /**
     * Gets the air quality
     *
     * @return airQuality - String format
     */
    public String getAirQuality() {
        airQuality = info.get(0);
        return airQuality;
    }

    /**
     * Gets the wind speed
     *
     * @return windSpeed - String format
     */
    public String getWindSpeed() {
        windSpeed = info.get(1);
        return windSpeed;
    }
}