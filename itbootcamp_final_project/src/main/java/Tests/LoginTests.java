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
    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getEmailInputField().getAttribute("type"),
                "email",
                "[ERROR] Email input field for the type attribute has no value email");
        Assert.assertEquals(loginPage.getPasswordInputField().getAttribute("type"),
                "password",
                "[ERROR] Password input field for the type attribute has no value password");
    }
}
