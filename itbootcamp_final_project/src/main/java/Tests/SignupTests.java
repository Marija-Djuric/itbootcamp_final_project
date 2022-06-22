package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 10)
    public void visitsTheSignupPage() {
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url of the page does not contain '/signup'");
    }
    @Test(priority = 20)
    public void checksInputTypes() {
        navPage.getSignUpButton().click();
        Assert.assertEquals(signupPage.getEmailInputField().getAttribute("type"),
                "email",
                "[ERROR] Email input field for the type attribute has no value email");
        Assert.assertEquals(signupPage.getPasswordInputField().getAttribute("type"),
                "password",
                "[ERROR] Password input field for the type attribute has no value password");
        Assert.assertEquals((signupPage.getConfirmPasswordInputField().getAttribute("type")),
                "password",
                "[ERROR] Confirm password input field for the type attribute has no value password");
    }
    @Test(priority = 30)
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";
        navPage.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url of the page does not contain '/signup'");
        signupPage.getNameInputField().sendKeys(name);
        signupPage.getEmailInputField().sendKeys(email);
        signupPage.getPasswordInputField().sendKeys(password);
        signupPage.getConfirmPasswordInputField().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForThePopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.errorMessaage().getText(),
                "E-mail already exists",
                "[ERROR] Pop up for error does not contain text 'E-mail already exists'");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url of the page does not contain '/signup'");
    }
}
