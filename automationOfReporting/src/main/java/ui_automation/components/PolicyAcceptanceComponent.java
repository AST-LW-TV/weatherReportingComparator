package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExplicitDriverWaits;

public class PolicyAcceptanceComponent {

    private WebDriver driver;

    @FindBy(id = "privacy-policy-banner")
    WebElement acceptPolicyBlock;

    @FindBy(css = ".policy-accept")
    private WebElement acceptPolicyButton;

    public PolicyAcceptanceComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnPolicy() {
        if (ExplicitDriverWaits.visibility(driver, acceptPolicyBlock) != null)
            acceptPolicyButton.click();
    }
}
