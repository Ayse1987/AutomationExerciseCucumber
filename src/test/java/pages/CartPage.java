package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy(xpath = "//h2[text()='Subscription']")
        public WebElement subscription;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeEmail;

    @FindBy(css = "button[id='subscribe']")
    public WebElement submitSubscribeArrow;

    @FindBy(css = "div[class='alert-success alert']")
    public WebElement successSubscriptionMessage;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> twoProductsInCart;

    @FindBy(xpath = "(//td[@class='cart_price'])[1]")
    public WebElement firstProductPrice;

    @FindBy(xpath = "(//td[@class='cart_price'])[2]")
    public WebElement secondProductPrice;

    @FindBy(xpath = "(//td[@class='cart_quantity'])[1]")
    public WebElement firstProductQuantity;

    @FindBy(xpath = "(//td[@class='cart_quantity'])[2]")
    public WebElement secondProductQuantity;

    @FindBy(xpath = "(//td[@class='cart_total'])[1]")
    public WebElement firstProductTotal;

    @FindBy(xpath = "(//td[@class='cart_total'])[2]")
    public WebElement secondProductTotal;

    @FindBy(xpath = "//*[text()='Blue Top']")
    public WebElement firstProductInCart;

   // @FindBy(css = "button[class='disabled']")
   // public WebElement firstProductQuantity;

    @FindBy(css = "a[class='btn btn-default check_out']")
    public  WebElement proceedToCheckOut;

    @FindBy(css = "a[href=\"/login\"] u")
    public  WebElement registerLoginButton;

    @FindBy(xpath = "//h2[contains(text(),'Address Details')]")
    public WebElement addressDetails;

    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    public WebElement reviewYourOrder;

    @FindBy(name = "message")
    public WebElement description;

    @FindBy(xpath = "//a[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/a")
    public WebElement deleteFirstProduct;

    @FindBy(xpath = "//*[text()='Your order has been placed successfully!']")
    public WebElement yourOrderPlacedMessage;
}
