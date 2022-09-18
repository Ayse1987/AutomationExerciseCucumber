package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CustomerHomePage;
import pages.HomePage;
import pages.LoginFormPage;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegistrationStepDef {

    HomePage homepage=new HomePage();
    LoginFormPage loginFormPage =new LoginFormPage();
    SignInPage signInPage=new SignInPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();
    Faker faker =new Faker();
    Select select;

    @Given("navigate to baseUrl")
    public void navigate_to_base_url() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @Given("verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        Assert.assertTrue(homepage.logo.isDisplayed());
    }

    @When("click on Signup Login button")
    public void click_on_signup_login_button() {
        homepage.signInLink.click();
    }

    @Then("verify New User Signup! is visible")
    public void verify_new_user_signup_is_visible() {
        Assert.assertTrue(homepage.newUserSignUpHeader.isDisplayed());
    }

    @Then("enter name and email address")
    public void enter_name_and_email_address() {
        homepage.nameBox.sendKeys(ConfigReader.getProperty("name"));
        homepage.signUpEmailTextBox.sendKeys(faker.internet().emailAddress());
    }

    @When("click Signup button")
    public void click_signup_button() {
        homepage.signUpButton.click();
    }

    @Then("verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_enter_account_information_is_visible() {
        Assert.assertTrue(loginFormPage.loginFormPageTitle.isDisplayed());
    }

    @Then("fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        loginFormPage.mrRadioBtn.click();
        loginFormPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
        select=new Select(loginFormPage.dayDropdown);
        select.selectByValue("1");
        select=new Select(loginFormPage.monthsDropdown);
        select.selectByValue("2");
        select=new Select(loginFormPage.yearDropdown);
        select.selectByValue("2000");
    }

    @Then("select checkbox Sign up for our newsletter!")
    public void select_checkbox_sign_up_for_our_newsletter() {
        loginFormPage.newsletterCheckBox.click();
    }

    @Then("select checkbox Receive special offers from our partners!")
    public void select_checkbox_receive_special_offers_from_our_partners() {
        loginFormPage.specialOfferCheckBox.click();
    }

    @Then("fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        loginFormPage.firstNameTexBox.sendKeys(ConfigReader.getProperty("name"));
        loginFormPage.lastNameTexBox.sendKeys(ConfigReader.getProperty("lastName"));
        loginFormPage.companyTexBox.sendKeys(ConfigReader.getProperty("company"));
        loginFormPage.address1TexBox.sendKeys(ConfigReader.getProperty("address1"));
        loginFormPage.address2TexBox.sendKeys(ConfigReader.getProperty("address2"));
        select=new Select(loginFormPage.countryDropDown);
        select.selectByValue(ConfigReader.getProperty("country"));
        loginFormPage.stateTextBox.sendKeys(ConfigReader.getProperty("state"));
        loginFormPage.cityTextBox.sendKeys(ConfigReader.getProperty("city"));
        loginFormPage.zipcodeTextBox.sendKeys("zipcode");
        loginFormPage.mobileNumberTextBox.sendKeys(ConfigReader.getProperty("mobileNumber"));
    }

    @When("click Create Account button")
    public void click_create_account_button() {
        loginFormPage.createAccountButton.click();
    }

    @Then("verify that ACCOUNT CREATED! is visible")
    public void verify_that_account_created_is_visible() {
        loginFormPage.accountCreatedMessage.isDisplayed();
    }

    @When("click Continue button")
    public void click_continue_button() {
        loginFormPage.continueButton.click();
    }

    @Then("verify that Logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        customerHomePage.loggedInExpression.isDisplayed();
    }

    @When("click Delete Account button")
    public void click_delete_account_button() {
        Assert.assertTrue(customerHomePage.deleteAccountLink.isDisplayed());
    }

    @Then("verify Delete Account button is visible")
    public void verifyDeleteAccountButtonIsVisible() {
        customerHomePage.deleteAccountLink.isDisplayed();
    }

    @Then("verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
    }

    @And("enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
    }

    @When("click login button")
    public void clickLoginButton() {
        signInPage.loginButton.click();
    }

    @And("enter incorrect email address and password")
    public void enterIncorrectEmailAddressAndPassword() {
        signInPage.loginEmailTextBox.sendKeys("ahmet@gmail.com");
        signInPage.loginPasswordTextBox.sendKeys("ahmet");
    }

    @Then("verify error Your email or password is incorrect! is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        Assert.assertTrue(signInPage.yourEmailAndPasswordWrongExpression.isDisplayed());
    }

    @When("click Logout button")
    public void clickLogoutButton() {
        customerHomePage.logOutLink.click();
    }

    @Then("verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        Assert.assertTrue(signInPage.loginToYourAccountExpression.isDisplayed());
    }

    @And("enter name and already registered email address")
    public void enterNameAndAlreadyRegisteredEmailAddress() {
        signInPage.nameBox.sendKeys(ConfigReader.getProperty("name"));
        signInPage.signUpEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
    }

    @Then("verify error Email Address already exist! is visible")
    public void verifyErrorEmailAddressAlreadyExistIsVisible() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(signInPage.emailAddressExistExpression.isDisplayed());
    }

    @And("close driver")
    public void closeDriver() {
        Driver.closeDriver();
    }
}
