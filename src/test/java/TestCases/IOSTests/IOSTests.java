package TestCases.IOSTests;

import Pages.IOS.AlertViewPage;
import TestUtils.Base.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSTests extends IOSBaseTest {

    @Test
    public void iosTC() {
        AlertViewPage alertViewPage = new AlertViewPage(iosDriver);
        alertViewPage.openAlertViewMenu();
        alertViewPage.submitTextEntry("Special Omar");
        alertViewPage.selectConfirmCancel();
        String text = alertViewPage.getConfirmationMessage();
        Assert.assertEquals(text, "A message should be a short, complete sentence.");
        alertViewPage.clickConfirm();
    }
}
