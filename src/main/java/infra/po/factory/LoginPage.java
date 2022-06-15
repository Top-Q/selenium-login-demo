package infra.po.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement userNameBy;

    @FindBy(id = "password")
    private WebElement passwordBy;

    @FindBy(tagName = "button")
    private WebElement loginBtnBy;

    @FindBy(linkText = "Register")
    private WebElement registerLnkBy;

    @FindBy(className = "alert")
    private WebElement alertDivBy;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeToUserNameTb(String userName){
        userNameBy.sendKeys(userName);
        return this;
    }

    public LoginPage typeToPasswordTb(String password){
        passwordBy.sendKeys(password);
        return this;
    }

    public HomePage clickOnLoginBtnAndGoToHomePage() {
        loginBtnBy.click();
        return new HomePage(driver);
    }

    public void clickOnLoginBtnAndDoNotLogin() {
        loginBtnBy.click();
    }

    public RegisterPage clickOnRegisterLnkAndGoToRegisterPage() {
        registerLnkBy.click();
        wait.until(ExpectedConditions.urlContains("register"));
        return new RegisterPage(driver);
    }
}