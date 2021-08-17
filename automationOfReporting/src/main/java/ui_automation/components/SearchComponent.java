package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExplicitDriverWaits;

import java.util.List;

// Input field component

public class SearchComponent extends AbstractComponent {

    @FindBy(css = "input[name='query']")
    WebElement searchField;

    @FindBy(css = ".search-result")
    List<WebElement> obtainedPlaceResults;

    @FindBy(css = ".results-container .search-result")
    List<WebElement> placeSuggestionsInResultPage;

    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    // entering place name, character by character
    private void enterPlaceNameByCharacter(String place) {
        int size = place.length();
        for (int i = 0; i < size - (size - 3); i++) {  // only three char are entered, so that we get suggestions with partial text
            searchField.sendKeys(place.charAt(i) + "");  // converting to string
        }
    }

    // gets number of place suggestions when partial place entered
    public int getNumberOfPlaceSuggestions(String place) {
        searchField.clear();
        enterPlaceNameByCharacter(place);
        ExplicitDriverWaits.waitForDropDownVisibility(driver, obtainedPlaceResults);
        return obtainedPlaceResults.size();
    }

    // selecting suggestion from the drop down
    public void selectFirstOptionFromDropDown(String place) {
        searchField.clear();
        enterPlaceNameByCharacter(place);
        obtainedPlaceResults.get(0).click();
    }

    // selecting place suggestion from drop down in result page
    public void selectPlaceInResultPlace(String place) {
        searchField.clear();
        enterPlaceNameByCharacter(place);
        ExplicitDriverWaits.waitForDropDownVisibility(driver, placeSuggestionsInResultPage);
        placeSuggestionsInResultPage.get(0).click();
    }
}