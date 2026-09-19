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

    private final By usernameLocator =By.name("username");
    private final By passwordLocator =By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage login(String username, String password){
        waitForElementPresent(usernameLocator);
        sendKeys(usernameLocator,username);
        waitForElementPresent(passwordLocator);
        sendKeys(passwordLocator, password);
        waitForElementClickable(loginButton);
        click(loginButton);
        return this;
    }


}
