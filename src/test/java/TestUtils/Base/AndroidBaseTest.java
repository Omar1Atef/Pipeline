package TestUtils.Base;

import Utils.Appium.AppiumActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

//hna ana 3aml extend appiumActions 3la dataprovider hya common ben ios w andorid fna 3yz fl test class a3ml call ll fun bta3t dataprovider direct bs ana momkn m3mlsh extend wfl test a5od object mn class appiumactions w5laas
public class AndroidBaseTest extends AppiumActions {

    public AppiumDriverLocalService service; //global variable for Appium service
    public AndroidDriver androidDriver; //global variable for Android driver

    @BeforeClass
    public void configAppium() throws URISyntaxException, IOException {

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data.properties");
        properties.load(fileInputStream);

        String localIPAddress ;
        if (System.getProperty("localIPAddress") != null) {
            localIPAddress = System.getProperty("localIPAddress");
        } else {
            localIPAddress = properties.getProperty("localIPAddress");
        }

//        String localIPAddress = System.getProperty("localIPAddress", properties.getProperty("localIPAddress"));


        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")) // Path to Appium
//                .withIPAddress(properties.getProperty("localIPAddress"))
                .withIPAddress(localIPAddress)
                .usingPort(Integer.parseInt(properties.getProperty("localPortNumber")))
                .build();

        service.start(); // Starts the Appium server

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("deviceName"));
        options.setPlatformName(properties.getProperty("platformName"));
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/General-Store.apk");
//        options.setApp("/Users/omaratef/IdeaProjects/AppiumProject/src/test/resources/General-Store.apk");


        androidDriver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
//        androidDriver = new AndroidDriver(service.getUrl(), options);

    }

//    @AfterMethod  // ← Runs AFTER EACH test method
//    public void tearDownDriver() {
//        if (androidDriver != null) {
//            androidDriver.quit();
//        }
//    }

    @AfterClass
    public void tearDownAppium() {
        androidDriver.quit();
        service.stop();
    }
}
