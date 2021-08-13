package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitDriverWaits {

    private static WebDriverWait wait;
    private static WebDriver driverToWait;
    private static WebElement webElement;

    private static void setUp(WebDriver driver) {
        driverToWait = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public static WebElement visibility(WebDriver driver, WebElement element) {
        webElement = null;
        setUp(driver);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
