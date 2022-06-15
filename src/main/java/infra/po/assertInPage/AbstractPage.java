package infra.po.assertInPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        assertInPage();
        System.out.println("In page " + this.getClass().getSimpleName());
        takeScreenshot();
    }

    protected abstract void assertInPage();

    private void takeScreenshot() {
    }




}
