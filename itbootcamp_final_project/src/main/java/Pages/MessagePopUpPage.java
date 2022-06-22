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

}
