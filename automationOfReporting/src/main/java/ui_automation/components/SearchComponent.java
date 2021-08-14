package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExplicitDriverWaits;

import java.util.List;

public class SearchComponent extends AbstractComponent {

    @FindBy(css="input[name='query']")
    WebElement searchField;

    @FindBy(css=".search-result")
    List<WebElement> obtainedPlaceResults;

    @FindBy(css=".results-container .search-result")
    List<WebElement> placeSuggestionsInResultPage;

    public SearchComponent(WebDriver driver){
        super(driver);
    }

    private void enterPlaceNameByCharacter(String place){
        int size=place.length();
        for(int i=0;i<size-(size-3);i++){  // only three char are entered, so that we get suggestions with partial text
            searchField.sendKeys(place.charAt(i)+"");  // converting to string
        }
    }

    public int getNumberOfPlaceSuggestions(String place){
        searchField.clear();
        enterPlaceNameByCharacter(place);
        ExplicitDriverWaits.waitForDropDownVisibility(driver,obtainedPlaceResults);
        return obtainedPlaceResults.size();
    }

    public void selectFirstOptionFromDropDown(String place){
        searchField.clear();
        enterPlaceNameByCharacter(place);
        obtainedPlaceResults.get(0).click();
    }

    public void selectPlaceInResultPlace(String place){
        searchField.clear();
        enterPlaceNameByCharacter(place);
        ExplicitDriverWaits.waitForDropDownVisibility(driver,placeSuggestionsInResultPage);
        placeSuggestionsInResultPage.get(0).click();
    }
}