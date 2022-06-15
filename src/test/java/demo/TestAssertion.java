package demo;

import infra.po.nobot.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertion extends AbstractTest {

    private static final String FIRST_NAME = "Itai";

    @Test
    public void testLoginWithWrongPassword0() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeToUserNameTb(FIRST_NAME);
        loginPage.typeToPasswordTb("WRONG PASSWORD");
        loginPage.clickOnLoginBtnAndStayInLoginPage();
        loginPage.assertAlertMessage("Username or password is incorrect");
    }

    @Test
    public void testLoginWithWrongPassword1() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeToUserNameTb(FIRST_NAME);
        loginPage.typeToPasswordTb("WRONG PASSWORD");
        loginPage.clickOnLoginBtnAndStayInLoginPage();

        String text = loginPage.waitForAlertMessage();
        Assert.assertEquals(text, "Username or password is incorrect");
    }

}
