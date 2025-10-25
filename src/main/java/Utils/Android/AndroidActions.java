package Utils.Android;

import Utils.Appium.AppiumActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class AndroidActions extends AppiumActions {

    AndroidDriver androidDriver;

    public AndroidActions(AndroidDriver androidDriver) {
//        super(androidDriver);
        this.androidDriver = androidDriver;
    }

    public void scrollToText(String text){
        androidDriver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }


    public void longPress(WebElement element){
        Map<String, Object> map = new HashMap<>();
        map.put("elementId", ((RemoteWebElement) element).getId());
        map.put("duration", 2000);
        androidDriver.executeScript("mobile: longClickGesture", map);
    }

}
