package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplicitDriverWaits {

    private static WebDriverWait wait;
    private static WebDriver driverToWait;

    private static void setUp(WebDriver driver) {
        driverToWait = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public static WebElement visibility(WebDriver driver, WebElement element) {
        setUp(driver);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForDropDownVisibility(WebDriver driver, List<WebElement> element) {
        setUp(driver);
        wait.until((driverToWait) -> (element.size() >= 3));
    }
}