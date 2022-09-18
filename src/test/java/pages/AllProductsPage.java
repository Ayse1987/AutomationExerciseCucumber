package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AllProductsPage {
    public AllProductsPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProductsHeader;

    @FindBy(css = "div[class='productinfo text-center']")
    public List<WebElement> productList;

    @FindBy(css = "a[href='/product_details/1']")
    public WebElement firstProductViewProductLink;

    @FindBy(xpath = "//h2[text()='Blue Top']")
    public WebElement productName;

    @FindBy(xpath = "//p[text()='Category: Women > Tops']")
    public WebElement categoryOfProduct;

    @FindBy(xpath = "//span[text()='Rs. 500']")
    public WebElement price;

    @FindBy(xpath = "//b[text()='Availability:']")
    public  WebElement availibility;

    @FindBy(xpath = "//b[text()='Condition:']")
    public WebElement condition;

    @FindBy(xpath = "//b[text()='Brand:']")
    public WebElement brand;

    @FindBy(id = "search_product")
    public WebElement searchBox;

    @FindBy(id = "submit_search")
    public WebElement submitSearch;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    public WebElement searchedProductsExpression;

    @FindBy(css = "div[class='productinfo text-center'] p")
    public List<WebElement> searchedProductList;

    @FindBy(css = "div[class='productinfo text-center'] img[src='/get_product_picture/1']")
    public WebElement firstProduct;

    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    public WebElement firstProductAddToChart;

    @FindBy(css = "button[class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingButton;

    @FindBy(css = "div[class='productinfo text-center'] img[src='/get_product_picture/2']")
    public WebElement secondProduct;

    @FindBy(xpath = "(//a[@data-product-id='2'])[1]")
    public WebElement secondProductAddToChart;

    @FindBy(css = "p[class='text-center'] a")
    public WebElement viewCartButton;

    @FindBy(xpath = "//h2[text()='Brands']")
    public WebElement brandsHeader;

    @FindBy(css = "a[href='/brand_products/Polo']")
    public WebElement polo;

    @FindBy(css = " i[class='fa fa-shopping-cart']")
    public List<WebElement> addAllProductsToCart;




}
