package ui_automation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// Abstract Class common for many components in UI (Parent class)

public abstract class AbstractComponent {

    protected WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}