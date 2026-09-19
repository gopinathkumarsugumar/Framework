package Steps;

import driver.DriverManager;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

public abstract class BaseStep {
    protected DriverManager driver;
    protected String authToken;

    @BeforeClass
    public void setUp(){
        driver = new DriverManager();
        System.out.println("Into the Setup Hook Step");
        DriverManager.getDriverInstance().manage().window().setSize(new Dimension(1920, 1080));
        DriverManager.getDriverInstance().get(ConfigReader.getProperty("url"));

        // Load the API authentication token once for every test class.
        // ORANGEHRM_API_TOKEN environment variable takes precedence over config.properties.
        authToken = ConfigReader.getProperty("token");
        System.out.println(authToken);
        if (authToken.isBlank()) {
            throw new IllegalStateException(
                    "API authentication token is missing. Set ORANGEHRM_API_TOKEN or api.token."
            );
        }
    }

    @AfterClass
    public void tearDown(){
//        DriverManager.quitBrowser();
    }
}
