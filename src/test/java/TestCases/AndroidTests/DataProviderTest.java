package TestCases.AndroidTests;

import Pages.Android.CartPage;
import Pages.Android.FillFromPage;
import Pages.Android.ProductsPage;
import TestUtils.Base.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataProviderTest extends AndroidBaseTest {

    @Test(dataProvider = "getData")
    //key
//    public void dataProviderTC(String country, String name, String gender) throws InterruptedException {
//
//        Thread.sleep(7000);
//        FillFromPage fillFromPage = new FillFromPage(androidDriver);
//        fillFromPage.selectCountry(country);
//        fillFromPage.setNameField(name);
//        fillFromPage.selectGender(gender);
//        fillFromPage.clickLetsShopButton();
//
//        ProductsPage productsPage = new ProductsPage(androidDriver);
//        productsPage.addToCartByIndex(0);
//        productsPage.addToCartByIndex(1);
//        CartPage cartPage = productsPage.clickCartButton();
//
//        Thread.sleep(5000);
//        double totalAmount = cartPage.getTotalAmount();
//        double totalPurchaseAmount = cartPage.getTotalPurchaseAmount();
//        Assert.assertEquals(totalAmount, totalPurchaseAmount);
//        cartPage.longPressOnTermsConditionButton();
//        cartPage.clickOnTermsButton();
//        cartPage.clickOnCheckBox();
//        cartPage.clickOnCompletePurchaseButton();
//
//    }

//    @DataProvider(name = "getData")
//    public Object[][] getData() {
//        return new Object[][]
//        {
//                { "Egypt", "Special", "male" }  //value
//        };
//    }


    public void dataProviderTC(HashMap<String, String> value) throws InterruptedException {

        Thread.sleep(7000);
        FillFromPage fillFromPage = new FillFromPage(androidDriver);
        fillFromPage.selectCountry(value.get("country"));
        fillFromPage.setNameField(value.get("name"));
        fillFromPage.selectGender(value.get("gender"));
        fillFromPage.clickLetsShopButton();

        ProductsPage productsPage = new ProductsPage(androidDriver);
        productsPage.addToCartByIndex(0);
        productsPage.addToCartByIndex(1);
        CartPage cartPage = productsPage.clickCartButton();

        Thread.sleep(5000);
        double totalAmount = cartPage.getTotalAmount();
        double totalPurchaseAmount = cartPage.getTotalPurchaseAmount();
        Assert.assertEquals(totalAmount, totalPurchaseAmount);
        cartPage.longPressOnTermsConditionButton();
        cartPage.clickOnTermsButton();
        cartPage.clickOnCheckBox();
        cartPage.clickOnCompletePurchaseButton();

    }

    @DataProvider(name = "getData")
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData("src/test/java/TestData/Android/Ecommerce.json"); //pass relative path of json file
        return new Object[][]
                {
                        { data.get(0) }
                };
    }
}
