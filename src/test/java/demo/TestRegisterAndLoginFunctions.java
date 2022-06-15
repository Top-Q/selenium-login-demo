package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TestRegisterAndLoginFunctions extends AbstractTest{

    private static final String FIRST_NAME = "Itai";
    private static final String LAST_NAME = "Agmon";
    private static final String PASSWORD = "secret";

    @Test
    public void testRegisterAndLogin() throws Exception {
        // Register new user
        driver.get("http://localhost:8080");
        String userName = FIRST_NAME + String.valueOf(System.currentTimeMillis());
        registerNewUser(FIRST_NAME, LAST_NAME, userName, PASSWORD);
        login(userName, PASSWORD);
        logout();
    }

    private void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    private void login(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("//h1[text()='Hi " + username + "!']")));
    }

    private void registerNewUser(String firstName, String lastName, String username, String password) {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
                .xpath("//div[text()='Registration successful']")));
    }


}
