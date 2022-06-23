package Tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.getHomeLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navPage.waitForPageToLoadUp();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url of the page does not contain '/login'");
    }
    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        navPage.getProfileLink();
        navPage.waitForPageToLoadUp();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url of the page does not contain '/login'");
    }
    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        navPage.getAdminCitiesPage();
        navPage.waitForPageToLoadUp();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url of the page does not contain '/login'");
    }
}
