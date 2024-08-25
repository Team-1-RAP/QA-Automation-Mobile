package com.test.stepdef.home;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.home.HomePage;
import pages.login.LoginPage;

import java.io.IOException;

public class HomeStep {

    private final AndroidDriver<AndroidElement> driver;


    public HomeStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @And("The user verify login success")
    public void verifyLoginSuccess() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyLoginSuccess());
    }

}
