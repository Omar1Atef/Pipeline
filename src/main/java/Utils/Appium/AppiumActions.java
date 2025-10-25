package Utils.Appium;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumActions {


    public double getFormattedAmount(String amount,String currency) {
        return Double.parseDouble(amount.replace(currency, "").trim());
    }

    public void waitElementToAppear(WebElement webElement,String attribute,String value,AppiumDriver appiumDriver) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.attributeContains(webElement, attribute, value));

    }

    // I pass the relative path of the json file
    public List<HashMap<String, String>> getJsonData(String relativePath) throws IOException {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Build the full path using the project directory
        String fullPath = System.getProperty("user.dir") + "/" + relativePath;

        // Read and convert the JSON file into a list of HashMaps
        List<HashMap<String, String>> data = objectMapper.readValue(
                new File(fullPath),
                new TypeReference<List<HashMap<String, String>>>() {}
        );

        return data;
    }

    public String getScreenShotPath(String screenshotName, AppiumDriver appiumDriver) throws IOException {
    File source = appiumDriver.getScreenshotAs(OutputType.FILE);
    String destinationFile = System.getProperty("user.dir") + "/Reports/" + screenshotName + ".png";
    FileUtils.copyFile(source, new File(destinationFile));
    return destinationFile;
    }

}