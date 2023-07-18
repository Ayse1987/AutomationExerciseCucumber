package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class newclasspage {
    public newclasspage(){
        PageFactory.initElements(Driver.getDriver(),this);}

@FindBy(xpath = "(//img[@alt='Faded Short Sleeve T-shirts'])[1]")
    public WebElement picture;

    @FindBy(xpath = "//div[@class='button-container']/a[@data-id-product='1']")
    public WebElement addtocart;

}
