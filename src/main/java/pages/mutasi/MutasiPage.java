package pages.mutasi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class MutasiPage extends BasePage {

    @AndroidFindBy(id = "com.team1.simplebank:id/spinner_item_month_new")
    private MobileElement monthFilter;

    @AndroidFindBy(id = "com.team1.simplebank:id/spinner_item_type_transcation_new")
    private MobileElement typeFilter;

    @AndroidFindBy(xpath = "(//*[@resource-id=\"com.team1.simplebank:id/layout_item_recyclerview\"])[1]")
    private MobileElement topMutasiInList;

    public MutasiPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void filterIsApplied(){
        topMutasiInList.isDisplayed();
    }

    public void clickInFilterByType(String type) throws Exception {
        clickByText(type);
    }

    public void clickInFilterByMonth(String month) throws Exception {
        clickByText(month);
    }

    public void clickFilterMutasi(String filter){
        MobileElement filterElement;
        switch (filter){
            case "Month":
                filterElement = monthFilter;
                break;
            case "Type":
                filterElement = typeFilter;
                break;
            default:
                throw new IllegalArgumentException("Filter " + filter + " not found");
        }
        filterElement.click();
    }

    public boolean redirectedToMutasiPage() throws Exception {
        waitForVisibility(monthFilter);
        monthFilter.isDisplayed();
        typeFilter.isDisplayed();
        topMutasiInList.isDisplayed();
        return true;
    }

}
