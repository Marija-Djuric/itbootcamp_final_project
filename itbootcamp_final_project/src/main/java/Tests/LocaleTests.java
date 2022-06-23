package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
    @Test(priority = 10)
    public void setLocaleToES() {
        navPage.getLanguageSelectionButton().click();
        navPage.getEsButtonFromLanguageSelection().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Página de aterrizaje"),
                "[ERROR] Header does not contain 'Página de aterrizaje'");
    }
    @Test(priority = 20)
    public void setLocaleToEN() {
        navPage.getLanguageSelectionButton().click();
        navPage.getEnButtonFromLanguageSelection().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Landing"),
                "[ERROR] Header does not contain 'Landing'");
    }
    @Test(priority = 30)
    public void setLocaleToCN() {
        navPage.getLanguageSelectionButton().click();
        navPage.getCnButtonFromLanguageSelection().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("首页"),
                "[ERROR] Header does not contain '首页'");
    }
    @Test(priority = 40)
    public void setLocaleToFR() {
        navPage.getLanguageSelectionButton().click();
        navPage.getFrButtonFromLanguageSelection().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Page d'atterrissage"),
                "[ERROR] Header does not contain 'Page d'atterrissage'");
    }
}
