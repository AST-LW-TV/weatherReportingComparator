package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import ui_automation.components.InformationModule;
import ui_automation.components.SearchComponent;

public class AccuWeatherResultsPage {

    private WebDriver driver;
    private SearchComponent searchComponent;
    private InformationModule informationModule;

    public AccuWeatherResultsPage(WebDriver driver){
        this.driver=driver;
        searchComponent=new SearchComponent(driver);
        informationModule=new InformationModule(driver);
    }

    public SearchComponent getSearchComponent(){
        return searchComponent;
    }

    public InformationModule getInformationModule(){
        return informationModule;
    }

}
