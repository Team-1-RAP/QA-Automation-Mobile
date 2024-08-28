package pages.profile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class ProfilePage extends BasePage {

    @AndroidFindBy(accessibility = "Keluar")
    private MobileElement logoutButton;

    @AndroidFindBy(xpath = "//*[@text=\"Iya\"]")
    private MobileElement iyaButton;

    public ProfilePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void clickIyaButton(){
        click(iyaButton);
    }

    public void clickLogoutButton(){
        click(logoutButton);
    }

    public void redirectedToProfilePage() throws Exception {
        waitForVisibility(logoutButton);
        logoutButton.isDisplayed();
    }

}
