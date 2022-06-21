package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getLanguageSelectionButton () {
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getEnButtonFromLanguageSelection () {
        return driver.findElement(By.className("btnEN"));
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')][1]"));
    }
}
