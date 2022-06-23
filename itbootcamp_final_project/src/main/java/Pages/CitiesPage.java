package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getNewItemButton () {
        return driver.findElement(By.className("btnNewItem"));
    }
    public void waitForTheEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("dlgNewEditItem")));
    }
    public WebElement getInputFieldForNewItem () {
        return driver.findElement(By.id("name"));
    }
}
