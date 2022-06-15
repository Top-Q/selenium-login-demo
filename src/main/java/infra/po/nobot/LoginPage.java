package infra.po.nobot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    private static final By userNameBy = By.id("username");
    private static final By passwordBy = By.id("password");
    private static final By loginBtnBy = By.tagName("button");
    private static final By registerLnkBy = By.linkText("Register");
    private static final By alertDivBy = By.className("alert");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeToUserNameTb(String userName){
        driver.findElement(userNameBy).sendKeys(userName);
        return this;
    }

    public LoginPage typeToPasswordTb(String password){
        driver.findElement(passwordBy).sendKeys(password);
        return this;
    }

    public HomePage clickOnLoginBtnAndGoToHomePage() {
        driver.findElement(loginBtnBy).click();
        return new HomePage(driver);
    }

    public void clickOnLoginBtnAndDoNotLogin() {
        driver.findElement(loginBtnBy).click();
    }

    public RegisterPage clickOnRegisterLnkAndGoToRegisterPage() {
        driver.findElement(registerLnkBy).click();
        wait.until(ExpectedConditions.urlContains("register"));
        return new RegisterPage(driver);
    }
}