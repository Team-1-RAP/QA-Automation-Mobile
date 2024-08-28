package com.test.stepdef.profile;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.profile.ProfilePage;
import pages.test.TestPage;

import java.io.IOException;

public class ProfileStep {

    private final AndroidDriver<AndroidElement> driver;


    public ProfileStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @And("The user click Iya button")
    public void clickIyaButton() throws Exception {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickIyaButton();
    }

    @And("The user click Logout button")
    public void clickLogoutButton() throws Exception {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
    }

    @Given("The user redirected to Profile page")
    public void redirectedToProfilePage() throws Exception {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.redirectedToProfilePage();
    }

}
