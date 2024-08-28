package pages.transfer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class TransferPage extends BasePage {

    @AndroidFindBy(id = "android:id/search_bar")
    MobileElement searchBar;

    @AndroidFindBy(id = "com.team1.simplebank:id/btn_new_user_transfer")
    MobileElement transferBaruButton;

    @AndroidFindBy(xpath = "//*[contains((@text), \"Pilih rekening sumber\")]")
    static MobileElement rekeningSumberField;

    @AndroidFindBy(id = "com.team1.simplebank:id/title_choose_destination_bank")
    MobileElement topRekeningSumber;

    @AndroidFindBy(id = "com.team1.simplebank:id/text_input_destination_bank")
    static MobileElement bankTujuanField;

    @AndroidFindBy(id = "com.team1.simplebank:id/text_input_number_account_destination")
    static MobileElement rekeningTujuanField;

    @AndroidFindBy(id = "com.team1.simplebank:id/text_input_transfer_information")
    static MobileElement keteranganField;

    @AndroidFindBy(id = "com.team1.simplebank:id/btn_next")
    static MobileElement selanjutnyaButton;

    @AndroidFindBy(id = "com.team1.simplebank:id/btn_transfer")
    static MobileElement transferButton;

    @AndroidFindBy(id = "com.team1.simplebank:id/transfer_account_username")
    static MobileElement nameRekeningTujuanInPreview;

    @AndroidFindBy(id = "com.team1.simplebank:id/account_number_and_destination_bank")
    static MobileElement detailRekeningTujuanInPreview;

    @AndroidFindBy(id = "com.team1.simplebank:id/text_input_transfer_total_amount")
    static MobileElement nominalField;

    @AndroidFindBy(id = "com.team1.simplebank:id/text_input_password_transaction")
    static MobileElement pinField;

    @AndroidFindBy(id = "com.team1.simplebank:id/nominal_transfer")
    static MobileElement nominalInKonfirmasiTransfer;

    @AndroidFindBy(id = "com.team1.simplebank:id/total_transfer")
    static MobileElement totalInKonfirmasiTransfer;

    @AndroidFindBy(id = "com.team1.simplebank:id/title_result_transfer")
    static MobileElement pembayaranBerhasilLabel;

    public TransferPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getValueGetTextInTransfer(String value){
        switch (value){
            case "nameRekeningTujuanInPreview":
                return nameRekeningTujuanInPreview.getText();
            case "nameBankTujuanInPreview":
                return detailRekeningTujuanInPreview.getText().split(" - ")[0];
            case "numberRekeningTujuanInPreview":
                return detailRekeningTujuanInPreview.getText().split(" - ")[1];
            case "nominalInKonfirmasiTransfer":
                return nominalInKonfirmasiTransfer.getText().replaceAll("(^0-9)","");
            case "totalInKonfirmasiTransfer":
                return totalInKonfirmasiTransfer.getText().replaceAll("(^0-9)","");
            case "pembayaranBerhasilLabel":
                return pembayaranBerhasilLabel.getText();
            default:
                throw new IllegalArgumentException("Value " + value + " not found");
        }
    }

    public void clickButtonInTransfer(String button){
        MobileElement buttonElement;
        switch (button){
            case "Transfer Baru":
                buttonElement = transferBaruButton;
                break;
            case "Selanjutnya":
                buttonElement = selanjutnyaButton;
                break;
            case "Transfer":
                buttonElement = transferButton;
                break;
            default:
                throw new IllegalArgumentException("Button " + button + " not fount");
        }
        click(buttonElement);
    }

    public void inputPin(String pin){
        sendKeys(pinField,pin);
    }

    public void inputNominal(String nominal){
        sendKeys(nominalField,nominal);
    }

    public void inputKeterangan(String keterangan){
        sendKeys(keteranganField,keterangan);
    }

    public void inputRekeningTujuan(String norek){
        sendKeys(rekeningTujuanField,norek);
    }

    public void inputBankTujuan(String bank){
        sendKeys(bankTujuanField,bank);
    }

    public static void putValueInTransfer(String key){
        switch (key){
            case "rekeningSumber":
                putValue(key,rekeningSumberField);
                break;
            case "bankTujuan":
                putValue(key,bankTujuanField);
                break;
            case "rekeningTujuan":
                putValue(key,rekeningTujuanField);
                break;
            case "keterangan":
                putValue(key,keteranganField);
                break;
            case "nominal":
                putValue(key,nominalField);
                break;
            default:
                throw new IllegalArgumentException("Value " + key + " not found");
        }
    }

    public static String getValueInTransfer(String key){
        switch (key){
            case "rekeningSumber":
            case "bankTujuan":
            case "rekeningTujuan":
            case "keterangan":
            case "nominal":
                return getValue(key);
            default:
                throw new IllegalArgumentException("Value " + key + " not found");
        }
    }

    public void selectTopRekeningSumber() throws InterruptedException {
        Thread.sleep(500);
        click(rekeningSumberField);
        Thread.sleep(500);
        click(topRekeningSumber);
    }

    public boolean onTransferPage(){
        waitForVisibility(searchBar);
        searchBar.isDisplayed();
        transferBaruButton.isDisplayed();
        return true;
    }

}
