package infra.po.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends AbstractPage {

    private static final By firstNameBy = By.id("firstName");
    private static final By lastNameBy = By.name("lastName");
    private static final By usernameBy = By.id("username");
    private static final By passwordBy = By.id("password");
    private static final By registerBy = By.cssSelector("button.btn-primary");


    public RegisterPage(ActionBot bot) {
        super(bot);
    }

    public RegisterPage typeToFirstNameTb(String firstName) {
        bot.sendKeysToElementLocatedBy(firstNameBy, firstName);
        return this;
    }

    public RegisterPage typeToLastNameTb(String lastName){
        bot.sendKeysToElementLocatedBy(lastNameBy, lastName);
        return this;
    }

    public RegisterPage typeToUserNameTb(String userName){
        bot.sendKeysToElementLocatedBy(usernameBy, userName);
        return this;
    }

    public RegisterPage typeToPasswordTb(String password){
        bot.sendKeysToElementLocatedBy(passwordBy, password);
        return this;
    }

    public LoginPage clickOnRegisterBtnAndGoToLoginPage(){
        bot.clickOnElementLocatedBy(registerBy);
        bot.waitForUrlToContain("login");
        return new LoginPage(bot);
    }

    public LoginPage doRegistration(String firstName, String lastName, String userName, String password) {
        typeToFirstNameTb(firstName);
        typeToLastNameTb(lastName);
        typeToUserNameTb(userName);
        typeToPasswordTb(password);
        return new LoginPage(bot);
    }
}
