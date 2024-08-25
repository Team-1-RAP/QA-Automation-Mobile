package pages.base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;

import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {
    public AndroidDriver<AndroidElement> driver;

    public BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibility(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e) {
        WebDriverWait wait = new WebDriverWait(driver, TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(MobileElement e, String msg) {
        waitForVisibility(e);
        e.click();
    }

    public void click(By e, String msg) {
        waitForVisibility(e);
        driver.findElement(e).click();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public void sendKeys(MobileElement e, String txt, String msg) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    public String getText(MobileElement e, String msg) {
        String txt;
        txt = getAttribute(e, "text");
        return txt;
    }

    public String getText(By e, String msg) {
        String txt;
        txt = getAttribute(e, "text");
        return txt;
    }

    public void closeApp() {
        ((InteractsWithApps) driver).closeApp();
    }

    public void launchApp() {
        ((InteractsWithApps) driver).launchApp();
    }

    public MobileElement scrollToElement(MobileElement element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.35);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 10000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public By scrollToElement(By element, String direction) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.5);
        int endX = (int) (size.width * 0.5);
        int startY = 0;
        int endY = 0;
        boolean isFound = false;

        switch (direction) {
            case "up":
                endY = (int) (size.height * 0.4);
                startY = (int) (size.height * 0.6);
                break;

            case "down":
                endY = (int) (size.height * 0.6);
                startY = (int) (size.height * 0.4);
                break;
        }

        for (int i = 0; i < 3; i++) {
            if (find(element, 1)) {
                isFound = true;
                break;
            } else {
                swipe(startX, startY, endX, endY, 10000);
            }
        }
        if(!isFound){
            throw new Exception("Element not found");
        }
        return element;
    }

    public boolean find(final MobileElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean find(final By element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (driver.findElement(element).isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public void swipe(int startX, int startY, int endX, int endY, int millis)
            throws InterruptedException {
        TouchAction t = new TouchAction(driver);
        t.press(point(startX, startY)).waitAction(waitOptions(ofMillis(millis))).moveTo(point(endX, endY)).release()
                .perform();
    }

    public void clickByText(String text) throws Exception {
        String x = "//*[contains(@text,\"" + text + "\")]";
        final By textXpath = By.xpath(x);
        scrollToElement(textXpath,"up");
        waitForVisibility(textXpath);
        click(textXpath,"");
    }

    public void sendKeysAndroidKey(String text) {
        Actions actions = new Actions(driver);
        Map<Character, AndroidKey> keyMap = new HashMap<>();
        keyMap.put('0', AndroidKey.DIGIT_0);
        keyMap.put('1', AndroidKey.DIGIT_1);
        keyMap.put('2', AndroidKey.DIGIT_2);
        keyMap.put('3', AndroidKey.DIGIT_3);
        keyMap.put('4', AndroidKey.DIGIT_4);
        keyMap.put('5', AndroidKey.DIGIT_5);
        keyMap.put('6', AndroidKey.DIGIT_6);
        keyMap.put('7', AndroidKey.DIGIT_7);
        keyMap.put('8', AndroidKey.DIGIT_8);
        keyMap.put('9', AndroidKey.DIGIT_9);
        keyMap.put('A', AndroidKey.A);
        keyMap.put('B', AndroidKey.B);
        keyMap.put('C', AndroidKey.C);
        keyMap.put('D', AndroidKey.D);
        keyMap.put('E', AndroidKey.E);
        keyMap.put('F', AndroidKey.F);
        keyMap.put('G', AndroidKey.G);
        keyMap.put('H', AndroidKey.H);
        keyMap.put('I', AndroidKey.I);
        keyMap.put('J', AndroidKey.J);
        keyMap.put('K', AndroidKey.K);
        keyMap.put('L', AndroidKey.L);
        keyMap.put('M', AndroidKey.M);
        keyMap.put('N', AndroidKey.N);
        keyMap.put('O', AndroidKey.O);
        keyMap.put('P', AndroidKey.P);
        keyMap.put('Q', AndroidKey.Q);
        keyMap.put('R', AndroidKey.R);
        keyMap.put('S', AndroidKey.S);
        keyMap.put('T', AndroidKey.T);
        keyMap.put('U', AndroidKey.U);
        keyMap.put('V', AndroidKey.V);
        keyMap.put('W', AndroidKey.W);
        keyMap.put('X', AndroidKey.X);
        keyMap.put('Y', AndroidKey.Y);
        keyMap.put('Z', AndroidKey.Z);
        keyMap.put('a', AndroidKey.A);
        keyMap.put('b', AndroidKey.B);
        keyMap.put('c', AndroidKey.C);
        keyMap.put('d', AndroidKey.D);
        keyMap.put('e', AndroidKey.E);
        keyMap.put('f', AndroidKey.F);
        keyMap.put('g', AndroidKey.G);
        keyMap.put('h', AndroidKey.H);
        keyMap.put('i', AndroidKey.I);
        keyMap.put('j', AndroidKey.J);
        keyMap.put('k', AndroidKey.K);
        keyMap.put('l', AndroidKey.L);
        keyMap.put('m', AndroidKey.M);
        keyMap.put('n', AndroidKey.N);
        keyMap.put('o', AndroidKey.O);
        keyMap.put('p', AndroidKey.P);
        keyMap.put('q', AndroidKey.Q);
        keyMap.put('r', AndroidKey.R);
        keyMap.put('s', AndroidKey.S);
        keyMap.put('t', AndroidKey.T);
        keyMap.put('u', AndroidKey.U);
        keyMap.put('v', AndroidKey.V);
        keyMap.put('w', AndroidKey.W);
        keyMap.put('x', AndroidKey.X);
        keyMap.put('y', AndroidKey.Y);
        keyMap.put('z', AndroidKey.Z);
        keyMap.put('@', AndroidKey.AT);
        keyMap.put('.', AndroidKey.PERIOD);
        keyMap.put('-', AndroidKey.MINUS);
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                actions.keyDown(Keys.SHIFT).sendKeys(String.valueOf(ch)).keyUp(Keys.SHIFT).perform();
            } else {
                actions.sendKeys(String.valueOf(ch)).perform();
            }
        }
    }

}