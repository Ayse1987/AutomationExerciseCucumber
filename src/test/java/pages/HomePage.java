package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class=\"logo pull-left\"]")
    public WebElement logo;

    @FindBy(css = "a i[class='fa fa-lock']")
    public WebElement signInLink;

    @FindBy(css = "div[class='signup-form'] h2")
    public WebElement newUserSignUpHeader;

    @FindBy(name = "name")
    public WebElement nameBox;

    @FindBy(css = "div[class='signup-form'] input[name='email']")
    public WebElement signUpEmailTextBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//a[@href='/contact_us']")
    public WebElement contactUsLink;

    @FindBy(css = "a[href='/test_cases'] i[class='fa fa-list']")
    public WebElement testCasesLink;

    @FindBy(css = "a[href='/products']")
    public WebElement productsLink;

    @FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    public WebElement subscriptionHeader;

    @FindBy(id = "susbscribe_email")
    public WebElement subscribeEmail;

    @FindBy(id = "subscribe")
    public WebElement subscribeArrow;

    @FindBy(id = "success-subscribe")
    public WebElement successSubscribe;

    @FindBy(xpath = "//header//a[@href='/view_cart']")
    public WebElement cart;

    @FindBy(xpath = "//*[text()='Category']")
    public  WebElement category;

    @FindBy(css="a[href='#Women']")
    public WebElement womanCategory;

    @FindBy(css = "a[href='/category_products/1']")
    public WebElement dressCategory;

    @FindBy(css = "div[class='recommended_items'] h2[class='title text-center']")
    public WebElement recommendedItemsHeader;

    @FindBy(css = "div[id='recommended-item-carousel'] a[data-product-id='1']")
    public WebElement firstRecommentedProductAddToCartButton;

    @FindBy(css = "img[src='get_product_picture/1']")
    public WebElement firstRecommendedProduct;

    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement viewCartLink;

    @FindBy(xpath = "//*[text()='Full-Fledged practice website for Automation Engineers'")
    public WebElement sentenceAtTheTop;

    @FindBy(css = "a[class='right recommended-item-control']")
    public WebElement rightRecommendedItemControl;
}
