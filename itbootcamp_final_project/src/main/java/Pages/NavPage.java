package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public WebElement getLogoutButton () {
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getSignUpButton () {
        return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')][2]"));
    }
    public void getHomeLink() {
        driver.navigate().to(driver.getCurrentUrl()+"home");
    }
    public WebElement getAdminButton ()  {
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton () {
        return driver.findElement(By.linkText("Cities"));
    }
    public void waitForPageToLoadUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
    }
    public void getProfileLink () {
        driver.navigate().to(driver.getCurrentUrl()+"profile");
    }
    public void getAdminCitiesPage() {
        driver.navigate().to(driver.getCurrentUrl()+("admin/cities"));
    }
    public void getAdminUsersPage() {
        driver.navigate().to(driver.getCurrentUrl()+("admin/users"));
    }
    public WebElement getEsButtonFromLanguageSelection () {
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getHeader() {
        return driver.findElement(By.tagName("h1"));
    }
    public WebElement getCnButtonFromLanguageSelection () {
        return driver.findElement(By.className("btnCN"));
    }
    public WebElement getFrButtonFromLanguageSelection () {
        return driver.findElement(By.className("btnFR"));
    }
}

