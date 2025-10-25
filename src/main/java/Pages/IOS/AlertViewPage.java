package Pages.IOS;

import Utils.IOS.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViewPage extends IOSActions {

    IOSDriver iosDriver;

    public AlertViewPage(IOSDriver iosDriver){
        super(iosDriver);
        this.iosDriver = iosDriver;
        PageFactory.initElements(new AppiumFieldDecorator(iosDriver), this);
    }

    // ============ WebElements ============

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement alertViewMenuButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Text Entry' AND type BEGINSWITH[c] 'XCUIElement'")
    private WebElement textEntryButton;

    @iOSXCUITFindBy(accessibility = "Text Entry")
    private WebElement textEntryField;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement okButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Confirm / Cancel\"")
    private WebElement confirmCancelButton;

    @iOSXCUITFindBy(accessibility = "A message should be a short, complete sentence.")
    private WebElement confirmationMessageLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm\"]")
    private WebElement confirmButton;


    public void openAlertViewMenu(){
        alertViewMenuButton.click();
    }

    public void selectConfirmCancel(){
        confirmCancelButton.click();
    }

    public void submitTextEntry(String text){
        textEntryButton.click();
        textEntryField.sendKeys(text);
        okButton.click();
    }

    public String getConfirmationMessage(){
        return confirmationMessageLabel.getText();
    }

    public void clickConfirm(){
        confirmButton.click();
    }

}