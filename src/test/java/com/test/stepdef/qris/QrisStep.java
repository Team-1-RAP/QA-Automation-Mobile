package com.test.stepdef.qris;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.qris.QrisPage;
import pages.test.TestPage;

import java.io.IOException;

public class QrisStep {

    private final AndroidDriver<AndroidElement> driver;


    public QrisStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @Then("The user verify qris show code displayed")
    public void qrisshowCodeDisplayed() throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.clickSelanjutnya();
    }

    @Then("The user input {string} in Pin")
    public void inputPin(String pin) throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.inputPin(pin);
    }

    @Then("The user click Selanjutnya button")
    public void clickSelanjutnya() throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.clickSelanjutnya();
    }

    @Then("The user input {string} in Nominal")
    public void inputNominal(String nominal) throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.inputNominal(nominal);
    }

    @Then("The user select top rekening in Pilih Rekening")
    public void selectTopRekening() throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.selectTopRekening();
    }

    @Then("The user click Show Code section")
    public void clickShowCode() throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.clickShowCode();
    }

    @Then("On Scan Code page, The user click {string} button")
    public void clickButtonInScanCode(String button) throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.clickButtonInScanCode(button);
    }

    @Then("The user redirected to Show Code section")
    public void redirectedToShowCodeSection() throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.redirectedToShowCodeSection();
    }

    @Then("The user redirected to Qris page")
    public void redirectedToQrisPage() throws Exception {
        QrisPage qrisPage = new QrisPage(driver);
        qrisPage.redirectedToQrisPage();
    }

}
