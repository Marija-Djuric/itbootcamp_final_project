package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test
    public void visitsTheSignupPage() {
        signupPage.getSignMeUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "[ERROR] Url of the page does not contain '/signup'");
    }
}
