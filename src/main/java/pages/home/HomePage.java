package pages.home;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class HomePage extends BasePage {

    @AndroidFindBy(accessibility = "Beranda")
    MobileElement berandaMenu;

    @AndroidFindBy(accessibility = "Mutasi")
    MobileElement mutasiMenu;

    @AndroidFindBy(accessibility = "QRIS")
    MobileElement qrisMenu;

    @AndroidFindBy(accessibility = "Profil")
    MobileElement profileMenu;

    @AndroidFindBy(id = "com.team1.simplebank:id/number_account_2")
    MobileElement numberAccount;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.team1.simplebank:id/layout_account_balance\"]/child::*[1]")
    MobileElement balanceAccountShow;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.team1.simplebank:id/layout_account_balance\"]/child::*[1]")
    MobileElement balanceAccountHide;

    @AndroidFindBy(accessibility = "Tampilkan Saldo")
    MobileElement showHideSaldo;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void clickIconInHome(String icon){
        MobileElement iconElement;
        switch (icon){
            case "Show":
            case "Hide":
                iconElement = showHideSaldo;
                break;
            default:
                throw new IllegalArgumentException("Icon " + icon + " not found");
        }
        iconElement.click();
    }

    public String getValueGetTextInHome(String value){
        switch (value){
            case "balanceShow":
                return balanceAccountShow.getText();
            case "balanceHide":
                return balanceAccountHide.getText();
            default:
                throw new IllegalArgumentException("Value " + value + " not found");
        }
    }

    public boolean onHomePage(){
        driver.closeApp();
        driver.launchApp();
        waitForVisibility(berandaMenu);
        berandaMenu.isDisplayed();
        mutasiMenu.isDisplayed();
        qrisMenu.isDisplayed();
        profileMenu.isDisplayed();
        return true;
    }

    public void clickMutasiMenu(){
        click(mutasiMenu);
    }

    public void clickQrisMenu(){
        click(qrisMenu);
    }

    public void clickProfileMenu(){
        click(profileMenu);
    }

    public boolean verifyLoginSuccess(){
        waitForVisibility(berandaMenu);
        berandaMenu.isDisplayed();
        numberAccount.isDisplayed();
        balanceAccountHide.isDisplayed();
        return true;
    }

}
