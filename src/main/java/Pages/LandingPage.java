package Pages;

import driver.DriverManager;
import groovy.util.logging.Log;
import org.openqa.selenium.By;
import utils.CommonActions;
import utils.ConfigReader;

public class LandingPage extends CommonActions {
    private DriverManager driver;

    public LandingPage(DriverManager driver){
        super(driver);
    }

    private By pimMenuButton = By.xpath("//span[text()='PIM']");

    public LandingPage validateHomeButton(){
        waitForElementPresent(pimMenuButton);
        return this;
    }
}
