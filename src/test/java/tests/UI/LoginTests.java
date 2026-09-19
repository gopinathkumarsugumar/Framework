package tests.UI;

import org.apache.poi.ss.usermodel.*;
import Pages.LandingPage;
import Pages.LoginPage;
import Steps.BaseStep;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestDataUtils;

import java.io.IOException;

public class LoginTests extends BaseStep {

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {
        return TestDataUtils.getExcelData(
                "src/test/resources/LoginData.xlsx",
                "LoginData"
        );
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password){
        new LoginPage(driver).login(username,password);
        new LandingPage(driver).validateHomeButton();
    }
}
