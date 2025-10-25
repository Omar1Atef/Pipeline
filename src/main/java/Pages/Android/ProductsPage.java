package Pages.Android;

import Utils.Android.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends AndroidActions {
    AndroidDriver androidDriver;

    public ProductsPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }


    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])")
    private List<WebElement> addToCartButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;


    public void addToCartByIndex(int index){
        addToCartButton.get(index).click();
    }

    public CartPage clickCartButton(){
        cartButton.click();
        return new CartPage(androidDriver);
    }

}
