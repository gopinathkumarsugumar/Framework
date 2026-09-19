package driver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CommonActions;

import static org.testng.Assert.fail;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(DriverManager.class);

    public DriverManager(){
        initDriver();
    }

    public static void initDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage()
                .window()
                .maximize();

        driver.set(webDriver);
    }

    public static WebDriver getDriverInstance() {
        if (driver.get() == null) {
            fail("Driver is null");
        }
        return driver.get();
    }

    public CommonActions commonActions(){
        return new CommonActions(this);
    }

    public static void quitBrowser(){
        if(driver.get() != null){
            getDriverInstance().close();
            getDriverInstance().quit();
            driver.remove();
            log.info("Driver closed and ThreadLocal removed.");
        }
    }
}
