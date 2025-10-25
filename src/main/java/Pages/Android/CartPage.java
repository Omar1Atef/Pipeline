package Pages.Android;

import Utils.Android.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AndroidActions {

    AndroidDriver androidDriver;

    public CartPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productsPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")
    private WebElement totalPurchaseAmount;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement readTermsConditionButton;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement termsButton;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement completePurchaseButton;

    public double getTotalAmount() {
        double totalAmount = 0.0;

        for (WebElement el : productsPrice) {
            String priceText = el.getText();
            double price = getFormattedAmount(priceText,"$");
            System.out.println("price: " + price);
            totalAmount += price;
        }

        System.out.println("Total amount: " + totalAmount);
        return totalAmount;
    }


    public double getTotalPurchaseAmount() {
        String totalAmountText = totalPurchaseAmount.getText();
        return getFormattedAmount(totalAmountText,"$");
    }

    public void longPressOnTermsConditionButton(){
        longPress(readTermsConditionButton);
    }

    public void clickOnTermsButton(){
        termsButton.click();
    }

    public void clickOnCheckBox(){
        checkBox.click();
    }

    public void clickOnCompletePurchaseButton(){
        completePurchaseButton.click();
    }

}
