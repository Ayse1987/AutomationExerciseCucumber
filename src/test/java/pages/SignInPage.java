package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {

        public SignInPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }


        @FindBy(css = "div[class='signup-form'] h2")
        public WebElement newUserSignUpHeader;

        @FindBy(name = "name")
        public WebElement nameBox;

        @FindBy(css = "div[class='signup-form'] input[name='email']")
        public WebElement signUpEmailTextBox;

        @FindBy(xpath = "//button[@data-qa='signup-button']")
        public WebElement signUpButton;

        @FindBy(xpath = "//h2[text()='Login to your account']")
        public WebElement loginToYourAccountExpression;

        @FindBy(css = "input[data-qa='login-email']")
        public WebElement loginEmailTextBox;

        @FindBy(css = "input[data-qa='login-password']")
        public WebElement loginPasswordTextBox;

        @FindBy(xpath = "//button[text()='Login']")
        public WebElement loginButton;

        @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
        public WebElement yourEmailAndPasswordWrongExpression;

        @FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
        public WebElement emailAddressExistExpression;

        @FindBy(css = "h2[class='title text-center']")
        public WebElement accountCreatedMessage;





    }


