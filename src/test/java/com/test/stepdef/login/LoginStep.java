package com.test.stepdef.login;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.login.LoginPage;
import pages.test.TestPage;

import java.io.IOException;

public class LoginStep {

    private final AndroidDriver<AndroidElement> driver;


    public LoginStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @Then("The user verify can hide password")
    public void canHidePassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickShowHidePassword();
        Assert.assertFalse(loginPage.canShowPassword().contains("Password2024!"));
    }

    @Then("The user verify can show password")
    public void canShowPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickShowHidePassword();
        Assert.assertEquals(loginPage.canShowPassword(),"Password2024!");
    }

    @Then("The user verify pop up biometrik is displayed")
    public void popUpBiometrikDisplayed(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.popUpBiometrikDisplayed());
    }

    @Then("The user verify login failed")
    public void verifyLoginFailed(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.onLoginPage());
    }

    @And("On Login page, The user click {string} button")
    public void clickButtonInLoginPage(String button) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickButtonInLoginPage(button);
    }

    @And("On Login page, The user input {string} in password")
    public void inputPassword(String password) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword(password);
    }

    @And("On Login page, The user input {string} in username")
    public void inputUsername(String username) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username);
    }

    @Then("The user is on Login page")
    public void onLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.onLoginPage());
    }

    @Given("The user open Simple Bank apps")
    public void openSimpleBank() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openSimpleBank();
    }

}
