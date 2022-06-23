package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.getHomeButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "[ERROR] Url of the page does not contain '/home'");
    }
}
