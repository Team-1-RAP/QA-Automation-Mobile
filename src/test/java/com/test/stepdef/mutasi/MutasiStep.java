package com.test.stepdef.mutasi;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.mutasi.MutasiPage;
import pages.test.TestPage;

import java.io.IOException;

public class MutasiStep {

    private final AndroidDriver<AndroidElement> driver;


    public MutasiStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @And("On Mutasi page, The user click {string} in filter by type")
    public void clickInFilterByType(String type) throws Exception {
        MutasiPage mutasiPage = new MutasiPage(driver);
        mutasiPage.clickInFilterByType(type);
    }

    @And("The user verify the filter is applied")
    public void filterIsApplied() throws Exception {
        MutasiPage mutasiPage = new MutasiPage(driver);
        mutasiPage.filterIsApplied();
    }

    @And("On Mutasi page, The user click {string} in filter by month")
    public void clickInFilterByMonth(String month) throws Exception {
        MutasiPage mutasiPage = new MutasiPage(driver);
        mutasiPage.clickInFilterByMonth(month);
    }

    @And("On Mutasi page, The user click {string} filter")
    public void clickFilterMutasi(String filter){
        MutasiPage mutasiPage = new MutasiPage(driver);
        mutasiPage.clickFilterMutasi(filter);
    }

    @Given("The user redirected to Mutasi page")
    public void redirectedToMutasiPage() throws Exception {
        MutasiPage mutasiPage = new MutasiPage(driver);
        Assert.assertTrue(mutasiPage.redirectedToMutasiPage());
    }

}
