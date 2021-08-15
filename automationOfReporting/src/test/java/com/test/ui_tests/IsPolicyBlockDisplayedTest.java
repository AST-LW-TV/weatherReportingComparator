package com.test.ui_tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui_automation.components.PolicyAcceptanceComponent;

@Listeners(common.Listeners.class)

public class IsPolicyBlockDisplayedTest extends BaseTest {

    private PolicyAcceptanceComponent policyComponent;

    @Test(groups = {"ui_regression_tests", "first_priority"})
    public void isPolicyBlockDisplayed() {
        policyComponent = new PolicyAcceptanceComponent(driver);
        Assert.assertTrue(policyComponent.isDisplayed());
    }
}