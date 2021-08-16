package utilities.browserSetup.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.browserSetup.BrowserConfiguration;
import utilities.jsonParserFunctions.JsonBlobType1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChromeBrowser extends BrowserConfiguration {

    private List<String> optionsOfBrowser;
    private ChromeOptions options;
    private WebDriver driver;
    private JsonBlobType1 js;

    @Override
    public void readBrowserProperties() {
        optionsOfBrowser = new ArrayList<>();
        js = new JsonBlobType1("chromeProperties");
        JSONArray array = (JSONArray) js.jsonParserBlobType("properties");
        for (int i = 0; i < array.size(); i++)
            optionsOfBrowser.add((String) array.get(i));
    }

    @Override
    public void setTheProperties() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        for (int i = 0; i < optionsOfBrowser.size(); i++)
            options.addArguments(optionsOfBrowser.get(i));
    }

    @Override
    public WebDriver returnTheDriver() {
        readBrowserProperties();
        setTheProperties();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}