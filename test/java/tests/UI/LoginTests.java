package tests.UI;

import Pages.LandingPage;
import Pages.LoginPage;
import Steps.BaseStep;
import org.testng.annotations.Test;

public class LoginTests extends BaseStep {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.validateHomeButton();
    }
}
