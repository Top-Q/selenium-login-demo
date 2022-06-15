package infra.po.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    private static final By userNameBy = By.id("username");
    private static final By passwordBy = By.id("password");
    private static final By loginBtnBy = By.tagName("button");
    private static final By registerLnkBy = By.linkText("Register");
    private static final By alertDivBy = By.className("alert");


    public LoginPage(ActionBot bot) {
        super(bot);
    }

    public LoginPage typeToUserNameTb(String userName){
        bot.sendKeysToElementLocatedBy(userNameBy, userName);
        return this;
    }

    public LoginPage typeToPasswordTb(String password){
        bot.sendKeysToElementLocatedBy(passwordBy, password);
        return this;
    }

    public HomePage clickOnLoginBtnAndGoToHomePage() {
        bot.clickOnElementLocatedBy(loginBtnBy);
        return new HomePage(bot);
    }

    public void clickOnLoginBtnAndStayInLoginPage() {
        bot.clickOnElementLocatedBy(loginBtnBy);
    }

    public RegisterPage clickOnRegisterLnkAndGoToRegisterPage() {
        bot.clickOnElementLocatedBy(registerLnkBy);
        bot.waitForUrlToContain("register");

        return new RegisterPage(bot);
    }

    public void assertAlertMessage(String username_or_password_is_incorrect) {
    }

    public String waitForAlertMessage() {
        bot.waitForVisibility(alertDivBy);
        return bot.getText(alertDivBy);
    }

    public HomePage doLogin(String userName, String password) {
        typeToUserNameTb(userName);
        typeToPasswordTb(password);
        return new HomePage(bot);
    }
}