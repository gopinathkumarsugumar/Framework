package Pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import utils.CommonActions;
import utils.ConfigReader;

public class LoginPage extends CommonActions {
    private DriverManager driver;

    public LoginPage(DriverManager driver){
        super(driver);
        this.driver = driver;
    }

    private final By username =By.name("username");
    private final By password =By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage login(){
        waitForElementPresent(username);
        sendKeys(username,ConfigReader.getProperty("username"));
        waitForElementPresent(password);
        sendKeys(password, ConfigReader.getProperty("password"));
        waitForElementClickable(loginButton);
        click(loginButton);
        return this;
    }


}
