package infra.po.noMembersWithNavigation;

import infra.po.nobot.AbstractPage;
import infra.po.nobot.LoginPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnLogoutBtnAndGoToLoginPage() {
        return new LoginPage(driver);
    }

    public void clickOnLogoutBtn() {
    }
}
