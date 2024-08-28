package com.test.stepdef.transfer;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.home.HomePage;
import pages.transfer.TransferPage;

import java.io.IOException;

public class TransferStep {

    private final AndroidDriver<AndroidElement> driver;


    public TransferStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @And("The user verify transfer is success")
    public void verifyTransferSuccess() throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        Assert.assertEquals(transferPage.getValueGetTextInTransfer("pembayaranBerhasilLabel"),"Pembayaran Berhasil");
    }

    @And("On Transfer page, The user input {string} as Pin")
    public void inputPin(String pin) throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        transferPage.inputPin(pin);
    }

    @And("On Transfer page, The user verify data in Konfirmasi Transfer is correct")
    public void verifyKonfirmasiTransferTujuan() throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        Assert.assertEquals(transferPage.getValueGetTextInTransfer("nominalInKonfirmasiTransfer"),TransferPage.getValueInTransfer("nominal"));
        Assert.assertEquals(transferPage.getValueGetTextInTransfer("totalInKonfirmasiTransfer"),TransferPage.getValueInTransfer("nominal"));
    }

    @And("On Transfer page, The user input {string} as Nominal")
    public void inputNominal(String nominal) throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        transferPage.inputNominal(nominal);
        TransferPage.putValueInTransfer("nominal");
    }

    @And("On Transfer page, The user verify preview Rekening Tujuan is correct")
    public void verifyPreviewRekeningTujuan() throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        Assert.assertEquals(transferPage.getValueGetTextInTransfer("nameRekeningTujuanInPreview"),"Test Website","Nama Rekening tujuan");
        Assert.assertEquals(transferPage.getValueGetTextInTransfer("nameBankTujuanInPreview"),TransferPage.getValueInTransfer("bankTujuan"),"Bank Tujuan");
        Assert.assertEquals(transferPage.getValueGetTextInTransfer("numberRekeningTujuanInPreview"),TransferPage.getValueInTransfer("rekeningTujuan"),"Nomer Rekening tujuan");
    }

    @And("On Transfer page, The user click {string} button")
    public void clickButtonInTransfer(String button) throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        transferPage.clickButtonInTransfer(button);
    }

    @And("On Transfer page, The user input {string} as Keterangan")
    public void inputKeterangan(String keterangan) throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        transferPage.inputKeterangan(keterangan);
        TransferPage.putValueInTransfer("keterangan");
    }

    @And("On Transfer page, The user input {string} as Rekening Tujuan")
    public void inputRekeningTujuan(String norek) throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        transferPage.inputRekeningTujuan(norek);
        TransferPage.putValueInTransfer("rekeningTujuan");
    }

    @And("On Transfer page, The user input {string} as Bank Tujuan")
    public void inputBankTujuan(String bank) throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        transferPage.inputBankTujuan(bank);
        TransferPage.putValueInTransfer("bankTujuan");
    }

    @And("On Transfer page, The user select top Rekening Sumber")
    public void selectTopRekeningSumber() throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        transferPage.selectTopRekeningSumber();
        TransferPage.putValueInTransfer("rekeningSumber");
    }

    @And("The user redirected to Transfer page")
    public void onHomePage() throws Exception {
        TransferPage transferPage = new TransferPage(driver);
        Assert.assertTrue(transferPage.onTransferPage());
    }

}
