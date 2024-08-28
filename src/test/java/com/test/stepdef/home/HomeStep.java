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

    @And("On Home page, The user verify balance is hide")
    public void balanceIsHide() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getValueGetTextInHome("balanceHide").contains("*****"));
    }

    @And("On Home page, The user verify balance is show")
    public void balanceIsShow() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.getValueGetTextInHome("balanceShow").contains("*****"));
    }

    @And("On Home page, The user click {string} balance icon")
    public void clickIconInHome(String icon) throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.clickIconInHome(icon);
    }

    @And("The user already on Home page")
    public void onHomePage() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.onHomePage());
    }

    @And("The user verify login success")
    public void verifyLoginSuccess() throws Exception {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyLoginSuccess());
    }

}
