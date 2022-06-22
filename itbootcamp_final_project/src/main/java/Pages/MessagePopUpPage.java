package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForThePopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__wrapper")));
    }
    public WebElement errorMessaage() {
        return driver.findElement(By.tagName("li"));
    }
    public void waitForTheVerifyYourAccountDialog() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-card")));
    }
    public WebElement headerFromTheVerifyYourAccountDialog() {
        return driver.findElement(By.className("dlgVerifyAccount"));
    }
    public WebElement closeButtonFromTheVerifyYourAccountDialog() {
        return driver.findElement(By.className("btnClose"));
    }
    public void waitForTheCloseButtonBeClicable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btnClose")));
    }
}