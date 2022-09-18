package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PaymentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class CheckOutStepDef {
    PaymentPage paymentPage = new PaymentPage();

    @Then("verify that the delivery address is same address filled at the time registration of account")
    public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
        System.out.println(paymentPage.deliveryAddress.getText());
        Assert.assertTrue(paymentPage.deliveryAddress.getText().contains(ConfigReader.getProperty("city")));

    }

    @Then("verify that the billing address is same address filled at the time registration of account")
    public void verify_that_the_billing_address_is_same_address_filled_at_the_time_registration_of_account() {
        Assert.assertTrue(paymentPage.billingAddress.getText().contains(ConfigReader.getProperty("city")));
    }

    @Then("click Download Invoice button and verify invoice is downloaded successfully.")
    public void click_download_invoice_button_and_verify_invoice_is_downloaded_successfully() {
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(3);
        //ReusableMethods.hover(paymentPage.downloadInvoiceButton);
        //WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        //wait.until(ExpectedConditions.elementToBeClickable(paymentPage.downloadInvoiceButton));
        Driver.waitAndClick(paymentPage.downloadInvoiceButton,3);
        ReusableMethods.waitFor(3);
        //actions.moveToElement(paymentPage.downloadInvoiceButton).click();
        Assert.assertTrue(ReusableMethods.isFileDownloaded("invoice"));
    }


    @Then("click Continue button in checkout")
    public void clickContinueButtonInCheckout() {
       // paymentPage.continueButton.click();
    }
}
