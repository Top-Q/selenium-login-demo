package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TestRegisterAndLoginFlat extends AbstractTest{

    private static final String FIRST_NAME = "Itai";
    private static final String LAST_NAME = "Agmon";
    private static final String PASSWORD = "secret";

    @Test
    public void testRegisterAndLogin() throws Exception {
        // Register new user
        driver.get("http://localhost:8080");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("firstName")).sendKeys(FIRST_NAME);
        driver.findElement(By.name("lastName")).sendKeys(LAST_NAME);
        String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("//div[text()='Registration successful']")));

        // Login
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.tagName("button")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("//h1[text()='Hi " + FIRST_NAME + "!']")));
        driver.findElement(By.linkText("Logout")).click();

    }


}
