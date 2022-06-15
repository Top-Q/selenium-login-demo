package infra.po.factory;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLogoutBtnAndGoToLoginPage() {
        return new LoginPage(driver);
    }
}
