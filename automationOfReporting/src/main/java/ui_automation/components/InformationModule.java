package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InformationModule extends AbstractComponent {

    @FindBy(css=".cur-con-weather-card__body .temp")
    WebElement temperature;

    @FindBy(css="div:nth-of-type(1) > .value")
    WebElement airQuality;

    @FindBy(css="div:nth-of-type(2) > .value")
    WebElement windSpeed;

    public InformationModule(WebDriver driver) {
        super(driver);
    }

    public String getCurrentTemperature(){
        return temperature
                .getText()
                .trim(); // index 0 has current temperature
    }

    public String getAirQuality(){
        return airQuality
                .getText()
                .trim();
    }

    public String getWindSpeed(){
        return windSpeed
                .getText()
                .trim();
    }
}
