package utilities.browserSetup.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.browserSetup.BrowserConfiguration;
import utilities.jsonParserFunctions.JsonBlobType1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirefoxBrowser extends BrowserConfiguration {

    private List<String> optionsOfBrowser;
    private FirefoxOptions options;
    private WebDriver driver;
    private JsonBlobType1 js;

    @Override
    public void readBrowserProperties() {
        optionsOfBrowser = new ArrayList<>();
        js = new JsonBlobType1("firefoxProperties");
        JSONArray array = (JSONArray) js.jsonParserBlobType("properties");
        for (int i = 0; i < array.size(); i++)
            optionsOfBrowser.add((String) array.get(i));
    }

    @Override
    public void setTheProperties() {
        WebDriverManager.firefoxdriver().setup();
        options = new FirefoxOptions();
        for (int i = 0; i < optionsOfBrowser.size(); i++)
            options.addArguments(optionsOfBrowser.get(i));
    }

    @Override
    public WebDriver returnTheDriver() {
        readBrowserProperties();
        setTheProperties();
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}