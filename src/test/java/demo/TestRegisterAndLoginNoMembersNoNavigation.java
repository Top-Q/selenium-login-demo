package demo;

import infra.po.noMembersNoNavigation.HomePage;
import infra.po.noMembersNoNavigation.RegisterPage;
import infra.po.noMembersNoNavigation.LoginPage;
import org.testng.annotations.Test;

public class TestRegisterAndLoginNoMembersNoNavigation extends AbstractTest{

    private static final String FIRST_NAME = "Itai";
    private static final String LAST_NAME = "Agmon";
    private static final String PASSWORD = "secret";

    @Test
    public void testRegisterAndLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterLnk();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.typeToFirstName(FIRST_NAME);
        registerPage.typeToLastName(LAST_NAME);
        String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
        registerPage.typeToUserName(userName);
        registerPage.typeToPasswordTb(PASSWORD);
        registerPage.clickOnRegisterBtn();

// OH MY GOD... DON'T USE SLEEP!!!
        Thread.sleep(1000);

        loginPage = new LoginPage(driver);
        loginPage.typeToUserNameTb(userName);
        loginPage.typeToPasswordTb(PASSWORD);
        loginPage.clickOnLoginBtn();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnLogoutBtn();

    }

}
