package stepdefinitions;

import data.Path;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import pages.ContactUsPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ContactUsStepDef {
    HomePage homePage=new HomePage();
    ContactUsPage contactUsPage=new ContactUsPage();

    @When("click on Contact Us button")
    public void click_on_contact_us_button() {
        homePage.contactUsLink.click();
    }
    @Then("verify GET IN TOUCH is visible")
    public void verify_get_in_touch_is_visible() {
        Assert.assertTrue(contactUsPage.getInTouchExpression.isDisplayed());
    }
    @Then("enter name, email, subject and message")
    public void enter_name_email_subject_and_message() {
        contactUsPage.nameTextBox.sendKeys(ConfigReader.getProperty("name"));
        contactUsPage.emailTextBox.sendKeys(ConfigReader.getProperty("email"));
        contactUsPage.subjectTextBox.sendKeys(ConfigReader.getProperty("subject"));
        contactUsPage.messageTextBox.sendKeys(ConfigReader.getProperty("message"));
    }
    @Then("upload file")
    public
    void upload_file() {

        contactUsPage.uploadFile.sendKeys(Path.filePath);

    }
    @When("click Submit button")
    public void click_submit_button() {
        contactUsPage.submitButton.click();

    }
    @When("click OK button")
    public void click_ok_button() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();

        //  ReusableMethods.waitFor(3);
      //  try {
      //      Driver.getDriver().switchTo().alert().accept();
      //  }catch(UnhandledAlertException e){
      //  }
      //  ReusableMethods.waitFor(3);
    }
    @Then("verify success message Success! Your details have been submitted successfully. is visible")
    public void verify_success_message_success_your_details_have_been_submitted_successfully_is_visible() {
        Assert.assertTrue(contactUsPage.successMessage.isDisplayed());
    }
    @Then("click Home button and verify that landed to home page successfully")
    public void click_home_button_and_verify_that_landed_to_home_page_successfully() {
        contactUsPage.homePageLink.click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals(ConfigReader.getProperty("homePageTitle")));
    }

}
