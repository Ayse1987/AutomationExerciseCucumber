package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PlaceOrderStepDef {
    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    CartPage cartPage=new CartPage();
    SignInPage signInPage=new SignInPage();
    CustomerHomePage customerHomePage=new CustomerHomePage();
    PaymentPage paymentPage=new PaymentPage();
    LoginFormPage loginFormPage=new LoginFormPage();
    Faker faker=new Faker();
    Select select;
    String newName;
    String email;

    @When("add products to cart")
    public void add_products_to_cart() {
        homePage.productsLink.click();
        ReusableMethods.hover(allProductsPage.firstProduct);
       ReusableMethods.clickWithJS(allProductsPage.firstProductAddToChart);
        allProductsPage.continueShoppingButton.click();
        ReusableMethods.hover(allProductsPage.secondProduct);
        ReusableMethods.clickWithJS(allProductsPage.secondProductAddToChart);
        homePage.cart.click();
    }
    @Then("verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        Assert.assertEquals(Driver.getDriver().getTitle(),ConfigReader.getProperty("viewCartPageTitle"));
    }
    @When("click Proceed To Checkout")
    public void click_proceed_to_checkout() {
        cartPage.proceedToCheckOut.click();
    }
    @When("click Register Login button")
    public void click_register_login_button() {
        cartPage.registerLoginButton.click();
    }
    @When("fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account() {
        newName=faker.name().toString();
        email=faker.internet().emailAddress();
        signInPage.nameBox.sendKeys(newName);
        signInPage.signUpEmailTextBox.sendKeys(email);
        signInPage.signUpButton.click();
        Assert.assertTrue(loginFormPage.loginFormPageTitle.isDisplayed());
        loginFormPage.mrRadioBtn.click();
        loginFormPage.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
        select=new Select(loginFormPage.dayDropdown);
        select.selectByValue("1");
        select=new Select(loginFormPage.monthsDropdown);
        select.selectByValue("2");
        select=new Select(loginFormPage.yearDropdown);
        select.selectByValue("2000");
        loginFormPage.newsletterCheckBox.click();
        loginFormPage.specialOfferCheckBox.click();
        ReusableMethods.waitFor(5);
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
        loginFormPage.createAccountButton.click();
        loginFormPage.accountCreatedMessage.isDisplayed();
        loginFormPage.continueButton.click();
    }
    @Then("verify ACCOUNT CREATED! and click Continue button")
    public void verify_account_created_and_click_continue_button() {
        Assert.assertTrue(loginFormPage.accountCreatedMessage.isDisplayed());
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER);
    }
    @When("click Proceed To Checkout button")
    public void click_proceed_to_checkout_button() {
       // Assert.assertTrue(signInPage.accountCreatedMessage.isDisplayed());
        Assert.assertTrue(customerHomePage.loggedInExpression.isDisplayed());
        homePage.cart.click();
        cartPage.proceedToCheckOut.click();}
    @Then("verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() {
        Assert.assertTrue(cartPage.addressDetails.isDisplayed()&cartPage.reviewYourOrder.isDisplayed());
    }
    @Then("enter description in comment text area and click Place Order")
    public void enter_description_in_comment_text_area_and_click_place_order() {
        cartPage.description.sendKeys("description");
    }
    @Then("enter payment details: Name on Card, Card Number, CVC, Expiration date")
    public void enter_payment_details_name_on_card_card_number_cvc_expiration_date() {
        cartPage.placeOrderButton.click();
        paymentPage.nameOnTheCard.sendKeys("ali");
        paymentPage.cardNumber.sendKeys("123");
        paymentPage.cvc.sendKeys("123");
        paymentPage.expiryMonth.sendKeys("January");
        paymentPage.expiryYear.sendKeys("2023");
    }
    @When("click Pay and Confirm Order button")
    public void click_pay_and_confirm_order_button() {
        paymentPage.payAndConfirmOrder.click();
    }
    @Then("verify success message Your order has been placed successfully!")
    public void verify_success_message_your_order_has_been_placed_successfully() {
        paymentPage.continueButton.click();
    }

    @And("fill email, password and click Login button")
    public void fillEmailPasswordAndClickLoginButton() {
        signInPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("email"));
        signInPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("password"));
        signInPage.loginButton.click();
    }
}
