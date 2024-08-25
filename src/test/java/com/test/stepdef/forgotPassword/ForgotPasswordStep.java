package com.test.stepdef.forgotPassword;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.forgotPassword.ForgotPasswordPage;
import pages.home.HomePage;

import java.io.IOException;

public class ForgotPasswordStep {

    private final AndroidDriver<AndroidElement> driver;


    public ForgotPasswordStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @And("The user verify redirected to Lupa Password page")
    public void verifyToLupaPasswordPage() throws Exception {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        Assert.assertTrue(forgotPasswordPage.verifyToLupaPasswordPage());
    }

}
