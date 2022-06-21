package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{
    @Test(priority = 10)
    public void visitsTheLoginPage() {
        navPage.getLanguageSelectionButton().click();
        navPage.getEnButtonFromLanguageSelection().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url of the page does not contain '/login'");
    }
}
