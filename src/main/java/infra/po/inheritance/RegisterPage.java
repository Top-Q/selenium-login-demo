package infra.po.inheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends DemoAppPage {

    private static final By firstNameBy = By.id("firstName");
    private static final By lastNameBy = By.name("lastName");
    private static final By usernameBy = By.id("username");
    private static final By passwordBy = By.id("password");
    private static final By registerBy = By.cssSelector("button.btn-primary");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage typeToFirstNameTb(String firstName) {
        driver.findElement(firstNameBy).sendKeys(firstName);
        return this;
    }

    public RegisterPage typeToLastNameTb(String lastName){
        driver.findElement(lastNameBy).sendKeys(lastName);
        return this;
    }

    public RegisterPage typeToUserNameTb(String userName){
        driver.findElement(usernameBy).sendKeys(userName);
        return this;
    }

    public RegisterPage typeToPasswordTb(String password){
        driver.findElement(passwordBy).sendKeys(password);
        return this;
    }

    public LoginPage clickOnRegisterBtnAndGoToLoginPage(){
        driver.findElement(registerBy).click();
        wait.until(ExpectedConditions.urlContains("login"));
        return new LoginPage(driver);
    }

    public LoginPage doRegistration(String firstName, String lastName, String userName, String password) {
        typeToFirstNameTb(firstName);
        typeToLastNameTb(lastName);
        typeToUserNameTb(userName);
        typeToPasswordTb(password);
        return new LoginPage(driver);
    }
}
