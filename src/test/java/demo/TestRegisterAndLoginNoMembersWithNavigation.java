package demo;

import infra.po.noMembersWithNavigation.HomePage;
import infra.po.noMembersWithNavigation.LoginPage;
import infra.po.noMembersWithNavigation.RegisterPage;
import org.testng.annotations.Test;

public class TestRegisterAndLoginNoMembersWithNavigation extends AbstractTest{

    private static final String FIRST_NAME = "Itai";
    private static final String LAST_NAME = "Agmon";
    private static final String PASSWORD = "secret";

    @Test
    public void testRegisterAndLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = loginPage.clickOnRegisterLnk();

        registerPage.typeToFirstName(FIRST_NAME);
        registerPage.typeToLastName(LAST_NAME);
        String userName = FIRST_NAME + System.currentTimeMillis();
        registerPage.typeToUserName(userName);
        registerPage.typeToPasswordTb(PASSWORD);
        loginPage = registerPage.clickOnRegisterBtn();

        loginPage.typeToUserNameTb(userName);
        loginPage.typeToPasswordTb(PASSWORD);
        HomePage homePage = loginPage.clickOnLoginBtn();

        homePage.clickOnLogoutBtn();

    }


}
