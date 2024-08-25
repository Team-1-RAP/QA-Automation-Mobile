package pages.forgotPassword;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class ForgotPasswordPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@text=\"Nomor Kartu\"]")
    MobileElement numberCardField;

    @AndroidFindBy(xpath = "//*[@text=\"MM\"]")
    MobileElement monthField;

    @AndroidFindBy(xpath = "//*[@text=\"YY\"]")
    MobileElement yearField;

    public ForgotPasswordPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public boolean verifyToLupaPasswordPage(){
        waitForVisibility(numberCardField);
        numberCardField.isDisplayed();
        monthField.isDisplayed();
        yearField.isDisplayed();
        return true;
    }

}
