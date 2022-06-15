package demo;

import infra.po.nobot.HomePage;
import infra.po.nobot.LoginPage;
import infra.po.nobot.RegisterPage;
import org.testng.annotations.Test;

public class TestRegisterAndLoginPO extends AbstractTest{

    private static final String FIRST_NAME = "Itai";
    private static final String LAST_NAME = "Agmon";
    private static final String PASSWORD = "secret";

    @Test
    public void testRegisterAndLogin() throws Exception {
        driver.get("http://localhost:8080");
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = loginPage.
                clickOnRegisterLnkAndGoToRegisterPage();

        String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
        loginPage = registerPage.
                typeToFirstName(FIRST_NAME).
                typeToLastName(LAST_NAME).
                typeToUserName(userName).
                typeToPasswordTb(PASSWORD).
                clickOnRegisterBtnAndGoToLoginPage();

        HomePage homePage = loginPage.
                typeToUserNameTb(userName).
                typeToPasswordTb(PASSWORD).
                clickOnLoginBtnAndGoToHomePage();


        homePage.clickOnLogoutBtnAndGoToLoginPage();

    }


}
