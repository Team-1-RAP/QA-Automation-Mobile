package pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "Profil")
    MobileElement profileButton;

    @AndroidFindBy(accessibility = "Keluar")
    MobileElement logoutButton;

    @AndroidFindBy(accessibility = "Iya")
    MobileElement yesLogoutButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN akun Simple Bankmu\"]/following-sibling::*[1]")
    MobileElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN akun Simple Bankmu\"]/following-sibling::*[2]")
    MobileElement passwordField;

    @AndroidFindBy(xpath = "//*[@text=\"Lupa Password?\"]")
    MobileElement forgotPasswordLink;

    @AndroidFindBy(accessibility = "Tombol Login")
    MobileElement loginButton;

    @AndroidFindBy(accessibility = "Tombol login biometrik")
    MobileElement biometrikButton;

    @AndroidFindBy(xpath = "//*[@text=\"Konfirmasi Sidik Jari\"]")
    MobileElement konfirmasiSidikJariLabel;

    @AndroidFindBy(accessibility = "Fingerprint Icon")
    MobileElement fingerPrintIcon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Password Icon\"]/following-sibling::*[1]")
    MobileElement showHidePasswordIcon;

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void clickButtonInLoginPage(String button) throws Exception {
        clickByText(button);
    }

    public String canShowPassword(){
        return passwordField.getText();
    }

    public void clickShowHidePassword(){
        click(showHidePasswordIcon);
    }

    public void inputPassword(String password){
        sendKeys(passwordField,password);
    }

    public void inputUsername(String username){
        sendKeys(usernameField,username);
    }

    public boolean popUpBiometrikDisplayed(){
        waitForVisibility(konfirmasiSidikJariLabel);
        konfirmasiSidikJariLabel.isDisplayed();
        fingerPrintIcon.isDisplayed();
        return true;
    }

    public boolean onLoginPage(){
        waitForVisibility(usernameField);
        usernameField.isDisplayed();
        passwordField.isDisplayed();
        loginButton.isDisplayed();
        return true;
    }

    public void openSimpleBank() throws InterruptedException {
        driver.closeApp();
        driver.launchApp();
        Thread.sleep(2000);
        try {
            clickProfileButton();
            clickLogoutButton();
            clickYesLogoutButton();
        } catch (Exception e){
            Thread.sleep(2000);
        }
    }

    public void clickProfileButton(){
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(profileButton));
        click(profileButton);
    }

    public void clickLogoutButton(){
        click(logoutButton);
    }

    public void clickYesLogoutButton(){
        click(yesLogoutButton);
    }


}
