package utils;

import Steps.BaseStep;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions extends BaseStep {

    private final WebDriver driver;
    public CommonActions(DriverManager driver){this.driver=DriverManager.getDriverInstance();}

    public WebElement findElement(By locator){
        return DriverManager.getDriverInstance().findElement(locator);
    }

    public void sendKeys(By locator, String key){
        WebElement webElement = waitForElementPresent(locator);
        webElement.sendKeys(key);
    }

    public void click(By locator){
        WebElement webElement = waitForElementPresent(locator);
        webElement.click();
    }

    // wait for element present
    public WebElement waitForElementPresent(By locator) {
        return new WebDriverWait(DriverManager.getDriverInstance(), Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // wait for element visible
    public WebElement waitForElementVisible(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // wait for element clickable
    public WebElement waitForElementClickable(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForTextToBePresentInElement(By locator, String expectedText) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public boolean waitForAttributeNotEmpty(By locator, String attributeName) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(webDriver -> {
                    WebElement element = webDriver.findElement(locator);
                    String value = element.getAttribute(attributeName);
                    return value != null && !value.isEmpty();
                });
    }

}
