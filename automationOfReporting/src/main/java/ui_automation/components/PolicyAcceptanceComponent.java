package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExplicitDriverWaits;

public class PolicyAcceptanceComponent extends AbstractComponent {

    @FindBy(id = "privacy-policy-banner")
    WebElement acceptPolicyBlock;

    @FindBy(css = ".policy-accept")
    private WebElement acceptPolicyButton;

    public PolicyAcceptanceComponent(WebDriver driver) {
        super(driver);
    }

    private WebElement waitForPolicyBlock() {
        return ExplicitDriverWaits.visibility(driver, acceptPolicyBlock);
    }

    public boolean isDisplayed() {
        return (waitForPolicyBlock() != null) ? true : false;
    }

    public void clickOnPolicy() {
        if (waitForPolicyBlock() != null)
            acceptPolicyButton.click();
    }
}