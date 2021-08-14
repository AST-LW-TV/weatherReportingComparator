package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import ui_automation.components.PolicyAcceptanceComponent;
import ui_automation.components.SearchComponent;

public class AccuWeatherHomePage {

    private WebDriver driver;
    private PolicyAcceptanceComponent policyComponent;
    private SearchComponent searchComponent;

    public AccuWeatherHomePage(WebDriver driver) {
        this.driver = driver;
        policyComponent = new PolicyAcceptanceComponent(driver);
        searchComponent = new SearchComponent(driver);
    }

    public PolicyAcceptanceComponent getPolicyComponent() {
        return policyComponent;
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }
}
