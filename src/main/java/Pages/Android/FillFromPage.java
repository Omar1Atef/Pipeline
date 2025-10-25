package Pages.Android;

import Utils.Android.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FillFromPage extends AndroidActions {
    AndroidDriver androidDriver;

    public FillFromPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }

    @AndroidFindBy(id ="android:id/text1")
    private WebElement selectCountry;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleGender;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleGender;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButton;

    public void selectCountry(String country){
        selectCountry.click();
        scrollToText(country);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"" + country + "\"]")).click();
    }

    public void setNameField(String name){
        nameField.sendKeys(name);
        androidDriver.hideKeyboard();
    }

    public void selectGender(String gender){
        if(gender.equalsIgnoreCase("male")){
            maleGender.click();
        }else{
            femaleGender.click();
        }
    }

    public void clickLetsShopButton(){
        letsShopButton.click();
    }

}