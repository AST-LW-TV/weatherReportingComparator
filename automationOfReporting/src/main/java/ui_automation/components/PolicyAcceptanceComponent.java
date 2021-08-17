package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExplicitDriverWaits;
import utilities.ReadPropertyFiles;

// policy component block properties

public class PolicyAcceptanceComponent extends AbstractComponent {

    @FindBy(id = "privacy-policy-banner")
    WebElement acceptPolicyBlock;

    @FindBy(css = ".policy-accept")
    private WebElement acceptPolicyButton;

    @FindBy(css = ".banner-dismiss-button")
    private WebElement dismissButton;

    public PolicyAcceptanceComponent(WebDriver driver) {
        super(driver);
    }

    // waiting for policy block to be visible
    private WebElement waitForPolicyBlock() {
        return ExplicitDriverWaits.visibility(driver, acceptPolicyBlock);
    }

    // checking whether the block is displayed or not
    public boolean isDisplayed() {
        return (waitForPolicyBlock() != null) ? true : false;
    }

    // clicking on the policy block
    public void clickOnPolicy() {
        if (waitForPolicyBlock() != null) {
            acceptPolicyButton.click();
            // if browser is firefox, then it again asks for notification enabling
            if (!ReadPropertyFiles.getValue("browserProperties", "browser").equalsIgnoreCase("chrome"))
                dismissButton.click();
        }
    }
}