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

    @AndroidFindBy(id = "com.team1.simplebank:id/hide_account_balance")
    MobileElement balanceAccount;

    @AndroidFindBy(accessibility = "Tampilkan Saldo")
    MobileElement showSaldo;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public boolean verifyLoginSuccess(){
        waitForVisibility(berandaMenu);
        berandaMenu.isDisplayed();
        numberAccount.isDisplayed();
        balanceAccount.isDisplayed();
        return true;
    }

}
