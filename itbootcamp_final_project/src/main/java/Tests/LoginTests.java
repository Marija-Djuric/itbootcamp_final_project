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
    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.loginErrorMessaages().getText(),
                "User does not exists",
                "[ERROR] Pop up for error does not contain text 'User does not exists'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url of the page does not contain '/login'");
    }
    @Test(priority = 40)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";
        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.loginErrorMessaages().getText(),
                "Wrong password",
                "[ERROR] Pop up for error does not contain text 'Wrong password'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Url of the page does not contain '/login'");
    }
}
