package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductDetailsPage {
    public ProductDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "quantity")
    public WebElement quantity;

    @FindBy(css = "button[class='btn btn-default cart']")
    public WebElement addToCart;

    @FindBy(css = "a[href='/view_cart'] u")
    public WebElement viewCart;

    @FindBy(xpath = "//*[text()='Write Your Review']")
    public WebElement writeYourReviewExpression;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "review")
    public WebElement review;

    @FindBy(id = "button-review")
    public WebElement reviewSubmitButton;

    @FindBy(xpath = "//*[text()='Thank you for your review.']")
    public  WebElement thankYouForReviewMessage;

}
