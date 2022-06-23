package Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginButton().click();
        loginPage.getEmailInputField().sendKeys(email);
        loginPage.getPasswordInputField().sendKeys(password);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] Url of the page does not contain '/admin/cities'");
    }
    @Test(priority = 20)
    public void checksInputTypesForCreateOrEditNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForTheEditDialogToBeVisible();
        Assert.assertEquals(citiesPage.getInputFieldForNewItem().getAttribute("type"),
                "text",
                "[ERROR] City input field for the attribute type has no value 'text'");
    }
    @Test(priority = 30)
    public void createNewCity() throws InterruptedException {
        String city = "M's city";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForTheEditDialogToBeVisible();
        citiesPage.getInputFieldForNewItem().sendKeys(city);
        citiesPage.getSaveButton().click();
        citiesPage.waitForThePopUpToBeVisibleCity();
        Assert.assertTrue(citiesPage.getAMessageFromAPopUpCity().getText().contains("Saved successfully"),
                "[ERROR] Pop up for error does not contain text 'Saved successfully'");
    }
    @Test(priority = 40)
    public void editCity() throws InterruptedException {
        String oldCityName = "M's city";
        String newCityName = "M's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getASearchField().sendKeys(oldCityName);
        citiesPage.waitForACertainNumberOfRowsToAppear(1);
        citiesPage.getEditButton(1).click();
        citiesPage.getEditInputField().click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(newCityName)
                .perform();
        citiesPage.getSaveButton().click();
        citiesPage.waitForThePopUpToBeVisibleCity();
        Assert.assertTrue(citiesPage.getAMessageFromAPopUpCity().getText().contains("Saved successfully"),
                "[ERROR] Pop up for error does not contain text 'Saved successfully'");
    }
    @Test(priority = 50)
    public void searchCity() throws InterruptedException {
        String cityName = "M's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getASearchField().sendKeys(cityName);
        citiesPage.waitForACertainNumberOfRowsToAppear(1);
        Assert.assertEquals(citiesPage.getACellFromASpecificRow(1,2).getText(),
                cityName,
                "[ERROR] In the first row of Name column is not text 'Marija's city Edited'");
    }
    @Test(priority = 60)
    public void deleteCity() {
        String cityName = "M's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();
        citiesPage.getASearchField().sendKeys(cityName);
        citiesPage.waitForACertainNumberOfRowsToAppear(1);
        Assert.assertEquals(citiesPage.getACellFromASpecificRow(1,2).getText(),
                cityName,
                "[ERROR] In the first row of Name column is not text 'Marija's city Edited'");
        citiesPage.getDeleteButton(1).click();
        citiesPage.waitForDeleteDialogToBeVIsible();
        citiesPage.getDeleteButtonFromDialog().click();
        messagePopUpPage.waitForThePopUpToBeVisible();
        Assert.assertTrue(citiesPage.getAMessageFromAPopUpCity().getText().contains("Deleted successfully"),
                "[ERROR] Pop up for error does not contain text 'Deleted successfully'");
    }
}
