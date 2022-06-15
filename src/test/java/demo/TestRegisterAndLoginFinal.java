package demo;

import infra.po.nobot.HomePage;
import infra.po.nobot.LoginPage;
import infra.po.nobot.RegisterPage;
import org.testng.annotations.Test;

public class TestRegisterAndLoginFinal extends AbstractTest{


    private static final String FIRST_NAME = "Itai";
    private static final String LAST_NAME = "Agmon";
    private static final String PASSWORD = "secret";

    @Test
    public void testRegisterAndLogin() {
        driver.get("http://localhost:8080");
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = loginPage.clickOnRegisterLnkAndGoToRegisterPage();

        String userName = FIRST_NAME + System.currentTimeMillis();
        loginPage = registerPage.doRegistration(FIRST_NAME, LAST_NAME, userName, PASSWORD);

        HomePage homePage = loginPage.doLogin(userName, PASSWORD);
        homePage.clickOnLogoutBtnAndGoToLoginPage();


    }



}
