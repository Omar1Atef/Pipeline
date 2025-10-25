package TestUtils.Base;

import Utils.Appium.AppiumActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class IOSBaseTest extends AppiumActions {

    public AppiumDriverLocalService service; //global variable for Appium service
    public IOSDriver iosDriver; //global variable for Android driver

    @BeforeClass
    public void configAppium() throws URISyntaxException, MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")) // Path to Appium
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start(); // Starts the Appium server

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 13 Pro");
        options.setPlatformName("IOS");
        options.setApp("/Users/omaratef/IdeaProjects/AppiumProject/src/test/resources/UIKitCatalog.app");
        options.setPlatformVersion("26.0");
        options.setWdaConnectionTimeout(Duration.ofSeconds(60)); // waits up to 60 seconds

        iosDriver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDownAppium() {
        iosDriver.quit();
        service.stop();
    }
}
