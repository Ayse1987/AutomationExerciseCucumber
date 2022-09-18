package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class VeifySubscription {

    HomePage homePage=new HomePage();

    @Given("scroll down to footer")
    public void scroll_down_to_footer() {
        Actions action=new Actions(Driver.getDriver());
        action.moveToElement(homePage.subscriptionHeader);
    }

    @Then("verify text SUBSCRIPTION")
    public void verify_text_subscription() {
        Assert.assertTrue(homePage.subscriptionHeader.isDisplayed());
    }

    @When("enter email address in input and click arrow button")
    public void enter_email_address_in_input_and_click_arrow_button() {
        homePage.subscribeEmail.sendKeys(ConfigReader.getProperty("email"));
        homePage.subscribeArrow.click();
    }

    @Then("verify success message You have been successfully subscribed! is visible")
    public void verify_success_message_you_have_been_successfully_subscribed_is_visible() {
        Assert.assertTrue(homePage.successSubscribe.isDisplayed());
    }


    @When("click Cart button")
    public void clickCartButton() {
        ReusableMethods.waitFor(3);
        homePage.cart.click();
    }

}
