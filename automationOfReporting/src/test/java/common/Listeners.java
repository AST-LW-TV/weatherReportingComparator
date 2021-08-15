package common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.Screenshots;

public class Listeners implements ITestListener {

    private ITestResult getResult;
    private WebDriver driver = null;
    private String status;

    private void miniFactory(String status) {
        ITestContext context = getResult.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriverInstance");
        Screenshots.TakeScreenShot(status, driver, getResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        this.getResult = result;
        status = "success";
        miniFactory(status);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        this.getResult = result;
        status = "failure";
        miniFactory(status);
    }
}