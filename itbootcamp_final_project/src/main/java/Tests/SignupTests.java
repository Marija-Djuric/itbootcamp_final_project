package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 10)
    public void visitsTheSignupPage() {
        signupPage.getSignMeUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url of the page does not contain '/signup'");
    }
    @Test(priority = 20)
    public void checksInputTypes() {
        signupPage.getSignMeUpButton().click();
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
}
