package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PaymentPage {
    public PaymentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "name_on_card")
    public WebElement nameOnTheCard;

    @FindBy(name = "card_number")
    public WebElement cardNumber;

    @FindBy(name = "cvc")
    public WebElement cvc;

    @FindBy(name = "expiry_month")
    public WebElement expiryMonth;

    @FindBy(name = "expiry_year")
    public WebElement expiryYear;

    @FindBy(id = "submit")
    public WebElement payAndConfirmOrder;

    @FindBy(xpath = "//*[text()='Your order has been placed successfully!']")
    public WebElement yourOrderPlacedMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(css = "ul[id='address_delivery'] li[class='address_city address_state_name address_postcode']")
    public  WebElement deliveryAddress;

    @FindBy(css = "ul[id='address_invoice'] li[class='address_city address_state_name address_postcode']")
    public  WebElement billingAddress;

    @FindBy(css = "a[href='/delete_account']")
    public WebElement deleteAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(@href,'download_invoice')]")
    public WebElement downloadInvoiceButton;





}
