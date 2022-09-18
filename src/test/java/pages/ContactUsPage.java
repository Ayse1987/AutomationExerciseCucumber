package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactUsPage {

    public ContactUsPage(){PageFactory.initElements(Driver.getDriver(),this);}

     @FindBy(xpath = "//h2[text()='Get In Touch']")
     public WebElement getInTouchExpression;

     @FindBy(css = "input[name='name']")
     public  WebElement nameTextBox;

     @FindBy(name = "email")
     public WebElement emailTextBox;

     @FindBy(name = "subject")
     public WebElement subjectTextBox;

     @FindBy(id = "message")
     public WebElement messageTextBox;

     @FindBy(name = "upload_file")
     public  WebElement uploadFile;

     @FindBy(name = "submit")
     public WebElement submitButton;

     @FindBy(css = "div[class='status alert alert-success']")
     public WebElement successMessage;

     @FindBy(css = "i[class='fa fa-angle-double-left']")
     public WebElement homePageLink;

}
