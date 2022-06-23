package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.getHomeLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navPage.waitForLoginPageToLoadUp();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url of the page does not contain '/login'");
    }

}
