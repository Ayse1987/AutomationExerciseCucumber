package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CartPage;
import pages.DressCategoryPage;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class CartstepDef {
    CartPage cartPage=new CartPage();
    HomePage homePage=new HomePage();
    DressCategoryPage dressCategoryPage=new DressCategoryPage();

    @When("click X button corresponding to particular product")
    public void click_x_button_corresponding_to_particular_product() {
        cartPage.deleteFirstProduct.click();
        ReusableMethods.waitFor(3);}
    @Then("verify that product is removed from the cart")
    public void verify_that_product_is_removed_from_the_cart() {
        WebElement firstProduct= Driver.getDriver().findElement(By.id("product-2"));

       // try {
            Assert.assertFalse(firstProduct.isDisplayed());
        System.out.println("asserted");
        //}catch (StaleElementReferenceException e){
            //Assert.assertTrue(true);
       // }
    }
    @Then("verify that categories are visible on left side bar")
    public void verify_that_categories_are_visible_on_left_side_bar() {
        Assert.assertTrue(homePage.category.isDisplayed());
    }
    @When("click on Women category")
    public void click_on_women_category() {
        ReusableMethods.hover(homePage.womanCategory);
        homePage.womanCategory.click();
    }
    @When("click on any category link under Women category, for example: Dress")
    public void click_on_any_category_link_under_women_category_for_example_dress() {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(homePage.dressCategory).click();
    }
    @Then("verify that category page is displayed and confirm text WOMEN - TOPS PRODUCTS")
    public void verify_that_category_page_is_displayed_and_confirm_text_women_tops_products() {
        Assert.assertTrue(dressCategoryPage.womanDressProducts.isDisplayed());

    }
    @Then("On left side bar, click on any sub-category link of Men category")
    public void on_left_side_bar_click_on_any_sub_category_link_of_men_category() {
        dressCategoryPage.menCategory.click();
        dressCategoryPage.tShirtCategory.click();
    }
    @Then("verify that user is navigated to that category page")
    public void verify_that_user_is_navigated_to_that_category_page() {
        Assert.assertTrue(dressCategoryPage.menTshirtProducts.isDisplayed());
    }

    @Then("verify RECOMMENDED ITEMS are visible")
    public void verifyRECOMMENDEDITEMSAreVisible() {
        Assert.assertTrue(homePage.recommendedItemsHeader.isDisplayed());
    }

    @And("click on Add To Cart on Recommended product")
    public void clickOnAddToCartOnRecommendedProduct() {
        if(homePage.firstRecommendedProduct.isDisplayed()){
            homePage.firstRecommentedProductAddToCartButton.click();
        }else{
            homePage.rightRecommendedItemControl.click();
            homePage.firstRecommentedProductAddToCartButton.click();
        }
    }

    @Then("verify that product is displayed in cart page")
    public void verifyThatProductIsDisplayedInCartPage() {
        ReusableMethods.waitFor(2);
        //homePage.viewCartLink.click();
        Assert.assertTrue(cartPage.firstProductInCart.isDisplayed());
    }
}
