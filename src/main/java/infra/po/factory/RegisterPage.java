package infra.po.factory;

import infra.po.nobot.AbstractPage;
import infra.po.nobot.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends AbstractPage {

    private static final By firstNameBy = By.id("firstName");
    private static final By lastNameBy = By.name("lastName");
    private static final By usernameBy = By.id("username");
    private static final By passwordBy = By.id("password");
    private static final By registerBy = By.cssSelector("button.btn-primary");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage typeToFirstName(String firstName) {
        driver.findElement(firstNameBy).sendKeys(firstName);
        return this;
    }

    public RegisterPage typeToLastName(String lastName){
        driver.findElement(lastNameBy).sendKeys(lastName);
        return this;
    }

    public RegisterPage typeToUserName(String userName){
        driver.findElement(usernameBy).sendKeys(userName);
        return this;
    }

    public RegisterPage typeToPasswordTb(String password){
        driver.findElement(passwordBy).sendKeys(password);
        return this;
    }

    public infra.po.nobot.LoginPage clickOnRegisterBtnAndGoToLoginPage(){
        driver.findElement(registerBy).click();
        wait.until(ExpectedConditions.urlContains("login"));
        return new LoginPage(driver);
    }

}
