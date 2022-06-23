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
    public WebElement getSaveButton () {
        return driver.findElement(By.className("btnSave"));
    }
    public void waitForThePopUpToBeVisibleCity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }
    public WebElement getAMessageFromAPopUpCity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
        return driver.findElement(By.className("success"));
    }
    public WebElement getASearchField() {
        return driver.findElement(By.id("search"));
    }
    public void waitForACertainNumberOfRowsToAppear(int numberOfRows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),numberOfRows+1));
    }
    public WebElement getEditButton() {
        return driver.findElement(By.id("edit"));
    }
    public WebElement getEditInputField() {
        return driver.findElement(By.id("name"));
    }
}
