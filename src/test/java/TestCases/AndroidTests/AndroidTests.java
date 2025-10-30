package TestCases.AndroidTests;

import Pages.Android.CartPage;
import Pages.Android.FillFromPage;
import Pages.Android.ProductsPage;
import TestUtils.Base.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTests extends AndroidBaseTest {

    @Test
    public void androidTC() throws InterruptedException {

        Thread.sleep(7000);
        FillFromPage fillFromPage = new FillFromPage(androidDriver);
        fillFromPage.selectCountry("Egypt");
        fillFromPage.setNameField("Special");
        fillFromPage.selectGender("male");
        fillFromPage.clickLetsShopButton();

        ProductsPage productsPage = new ProductsPage(androidDriver);
        productsPage.addToCartByIndex(0);
        productsPage.addToCartByIndex(1);
        CartPage cartPage = productsPage.clickCartButton();


        double totalAmount = cartPage.getTotalAmount();
        double totalPurchaseAmount = cartPage.getTotalPurchaseAmount();
        Assert.assertEquals(totalAmount, totalPurchaseAmount);
        cartPage.longPressOnTermsConditionButton();
        cartPage.clickOnTermsButton();
        cartPage.clickOnCheckBox();
        cartPage.clickOnCompletePurchaseButton();

    }

}
// I will push pipeline auto trigger now