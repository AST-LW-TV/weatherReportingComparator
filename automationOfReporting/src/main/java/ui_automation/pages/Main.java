package ui_automation.pages;

import comparator_logic.actions.WebActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui_automation.components.InformationModule;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.accuweather.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebActions hpa=new WebActions(driver);
//        hpa.navigateToResultsPage();

        InformationModule im=new InformationModule(driver);
        System.out.println(im.getCurrentTemperature());
        System.out.println(im.getAirQuality());
        System.out.println(im.getWindSpeed());
    }
}
