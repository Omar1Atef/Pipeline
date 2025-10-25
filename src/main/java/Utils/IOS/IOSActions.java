package Utils.IOS;

import Utils.Appium.AppiumActions;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumActions {

    IOSDriver iosDriver;

    public IOSActions(IOSDriver iosDriver) {
//        super(iosDriver);
        this.iosDriver = iosDriver;
    }


}
