package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DressCategoryPage {
    public DressCategoryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "h2[class='title text-center']")
    public WebElement womanDressProducts;

    @FindBy(css = "a[href='#Men']")
    public WebElement menCategory;

    @FindBy(xpath = "//a[text()='Tshirts ']")
    public WebElement tShirtCategory;

    @FindBy(xpath = "//*[text()='Men - Tshirts Products']")
    public WebElement menTshirtProducts;

    @FindBy(xpath = "//*[text()='Brand - Polo Products']")
    public WebElement poloProductsExpression;

    @FindBy(css ="a[href=\"/brand_products/H&M\"]" )
    public WebElement hmBrandLink;

    @FindBy(xpath = "//h2[text()='Brand - H&M Products']")
    public WebElement hmProductsExpression;
}
