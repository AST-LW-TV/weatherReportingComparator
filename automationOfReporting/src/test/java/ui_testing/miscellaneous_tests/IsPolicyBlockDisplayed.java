package ui_testing.miscellaneous_tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ui_automation.components.PolicyAcceptanceComponent;
import ui_testing.BaseTest;

public class IsPolicyBlockDisplayed extends BaseTest {

    private PolicyAcceptanceComponent policyComponent;

    @Test
    public void isPolicyBlockDisplayed() {
        policyComponent = new PolicyAcceptanceComponent(driver);
        Assert.assertTrue(policyComponent.isDisplayed());
    }
}