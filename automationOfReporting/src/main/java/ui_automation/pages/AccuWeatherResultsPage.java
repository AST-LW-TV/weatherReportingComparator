package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import ui_automation.components.InformationModule;

public class AccuWeatherResultsPage {

    private WebDriver driver;
    private InformationModule informationModule;

    public AccuWeatherResultsPage(WebDriver driver){
        this.driver=driver;
        informationModule=new InformationModule(driver);
    }

    public InformationModule getInformationModule(){
        return informationModule;
    }

}
