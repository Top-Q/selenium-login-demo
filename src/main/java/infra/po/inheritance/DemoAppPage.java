package infra.po.inheritance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoAppPage extends AbstractPage {

    private static final By registrationAndLoginExampleLnkBy = By.linkText("AngularJS User Registration and Login Example");

    private static final By jasonWatmoreLnkBy = By.linkText("JasonWatmore.com");

    public DemoAppPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegistrationAndLoginExampleLnk() {
        driver.findElement(registrationAndLoginExampleLnkBy).click();
    }

    public void clickOnJasonWatmoreLnk() {
        driver.findElement(jasonWatmoreLnkBy).click();
    }
}
