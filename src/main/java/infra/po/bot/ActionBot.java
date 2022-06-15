package infra.po.bot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionBot {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ActionBot(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void clickOnElementLocatedBy(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void sendKeysToElementLocatedBy(By by, String keys){
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(keys);
    }

    public void waitForUrlToContain(String urlText) {
        wait.until(ExpectedConditions.urlContains(urlText));
    }

    public void waitForVisibility(By by) {
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getText(By alertDivBy) {
        return driver.findElement(alertDivBy).getText();
    }
}
