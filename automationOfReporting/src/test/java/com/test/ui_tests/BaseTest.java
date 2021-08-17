package com.test.ui_tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.ReadPropertyFiles;
import utilities.VideoRecorder;
import utilities.browserSetup.BrowserFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context) {
        VideoRecorder.startRecording();
        driver = BrowserFactory.getDriver();
        driver.get(ReadPropertyFiles.getValue("urlProperties", "url"));
        context.setAttribute("WebDriverInstance", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        VideoRecorder.stopRecording();
    }
}