package infra.po.bot;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(ActionBot bot) {
        super(bot);
    }

    public LoginPage clickOnLogoutBtnAndGoToLoginPage() {
        return new LoginPage(bot);
    }
}
