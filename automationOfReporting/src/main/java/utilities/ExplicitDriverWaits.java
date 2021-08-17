package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// Explicit waits used in the application

public class ExplicitDriverWaits {

    private static WebDriverWait wait;
    private static WebDriver driverToWait;

    private static void setUp(WebDriver driver) {
        driverToWait = driver;
        wait = new WebDriverWait(driver, 20);
    }

    // waits for the visibility of the element
    public static WebElement visibility(WebDriver driver, WebElement element) {
        setUp(driver);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // waits for the drop down to be visible having more than or equal to 3 suggestions
    public static void waitForDropDownVisibility(WebDriver driver, List<WebElement> element) {
        setUp(driver);
        wait.until((driverToWait) -> (element.size() >= 3));
    }

    public static void waitForElementVisibility(WebDriver driver, By elementLocator) {
        setUp(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}