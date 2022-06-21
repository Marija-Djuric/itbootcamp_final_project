package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getSignMeUpButton () {
        return driver.findElement(By.linkText("SIGN UP"));
    }


}
