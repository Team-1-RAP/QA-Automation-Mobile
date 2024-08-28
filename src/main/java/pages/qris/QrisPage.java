package pages.qris;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class QrisPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@text='scan kode']")
    private MobileElement scanKodeSection;

    @AndroidFindBy(xpath = "//*[@text='tampilkan kode']")
    private MobileElement tampilkanKodeSection;

    @AndroidFindBy(accessibility = "ambil dari galeri")
    private MobileElement galeryButton;

    @AndroidFindBy(accessibility = "flash")
    private MobileElement flashButton;

    @AndroidFindBy(xpath = "//*[@text='Pilih Rekening']")
    private MobileElement pilihRekeningField;

    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement topRekening;

    @AndroidFindBy(accessibility = "Masukkan nominal")
    private MobileElement nominalField;

    @AndroidFindBy(accessibility = "Masukkan pin")
    private MobileElement pinField;

    @AndroidFindBy(xpath = "//*[@text='Selanjutnya']")
    private MobileElement selanjutnyaButton;

    @AndroidFindBy(xpath = "//*[@text='Qris']")
    private MobileElement qrisCode;


    public QrisPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void qrisShowCodeDisplayed(){
        qrisCode.isDisplayed();
    }

    public void clickSelanjutnya(){
        click(selanjutnyaButton);
    }

    public void inputPin(String pin){
        sendKeys(pinField,pin);
    }

    public void inputNominal(String nominal){
        sendKeys(nominalField,nominal);
    }

    public void selectTopRekening(){
        click(pilihRekeningField);
        click(topRekening);

    }

    public void redirectedToShowCodeSection() throws Exception {
        waitForVisibility(pilihRekeningField);
        pilihRekeningField.isDisplayed();
        nominalField.isDisplayed();
    }

    public void clickShowCode(){
        click(tampilkanKodeSection);
    }

    public void clickButtonInScanCode(String button){
        MobileElement buttonElement;
        switch (button){
            case "Galery":
                buttonElement = galeryButton;
                break;
            case "Flash":
                buttonElement = flashButton;
                break;
            default:
                throw new IllegalArgumentException("Button " + button + " not found");
        }
        buttonElement.click();
    }

    public void redirectedToQrisPage() throws Exception {
        waitForVisibility(scanKodeSection);
        scanKodeSection.isDisplayed();
        tampilkanKodeSection.isDisplayed();
    }

}
