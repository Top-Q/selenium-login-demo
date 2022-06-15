package demo;

import infra.po.nobot.HomePage;
import infra.po.nobot.LoginPage;
import org.testng.annotations.Test;

public class TestRegisterAndLoginWithGoto extends AbstractTest{

    private static final String FIRST_NAME = "Itai";
    private static final String LAST_NAME = "Agmon";
    private static final String PASSWORD = "secret";

    @Test
    public void testLoginWithWrongPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeToUserNameTb(FIRST_NAME);
        loginPage.typeToPasswordTb("WRONG PASSWORD");
        loginPage.clickOnLoginBtnAndStayInLoginPage();
    }

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeToUserNameTb(FIRST_NAME);
        loginPage.typeToPasswordTb(PASSWORD);
        HomePage homePage = loginPage.clickOnLoginBtnAndGoToHomePage();
    }


}
