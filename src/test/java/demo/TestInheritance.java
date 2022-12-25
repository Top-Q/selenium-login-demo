package demo;

import infra.po.inheritance.LoginPage;
import infra.po.inheritance.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestInheritance extends AbstractTest {

    private static final String TUTORIAL_URL = "https://jasonwatmore.com/post/2015/03/10/angularjs-user-registration-and-login-example-tutorial";
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver.get("http://localhost:8080");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testClickOnLoginExampleFromLoginPage() {
        loginPage.clickOnRegistrationAndLoginExampleLnk();
        Assert.assertEquals(driver.getCurrentUrl(), TUTORIAL_URL);
    }

    @Test
    public void testClickOnLoginExampleFromRegisterPage() {
        RegisterPage registerPage = loginPage.clickOnRegisterLnkAndGoToRegisterPage();
        registerPage.clickOnRegistrationAndLoginExampleLnk();
        Assert.assertEquals(driver.getCurrentUrl(), TUTORIAL_URL);
    }


}
