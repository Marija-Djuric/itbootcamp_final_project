package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        String city = "Marija's city";
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
}
