package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.AllProductsPage;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.concurrent.TimeUnit;

public class ProductsStepDef {
    HomePage homePage=new HomePage();
    AllProductsPage allProductsPage=new AllProductsPage();
    CartPage cartPage=new CartPage();
    ProductDetailsPage productDetailsPage=new ProductDetailsPage();

    @When("click on Products button")
    public void click_on_products_button() {
        homePage.productsLink.click();

    }
    @Then("verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        Assert.assertTrue(allProductsPage.allProductsHeader.isDisplayed());

    }
    @Then("the products list is visible")
    public void the_products_list_is_visible() {
        Assert.assertTrue(allProductsPage.allProductsHeader.isDisplayed());

    }
    @When("click on View Product of first product")
    public void click_on_view_product_of_first_product() {
        allProductsPage.firstProductViewProductLink.click();

    }
    @Then("user is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals(ConfigReader.getProperty("productDetailPageTitle")));

    }
    @Then("verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
        Assert.assertTrue(allProductsPage.productName.isDisplayed());
        Assert.assertTrue(allProductsPage.categoryOfProduct.isDisplayed());
        Assert.assertTrue(allProductsPage.price.isDisplayed());
        Assert.assertTrue(allProductsPage.availibility.isDisplayed());
        Assert.assertTrue(allProductsPage.condition.isDisplayed());
        Assert.assertTrue(allProductsPage.brand.isDisplayed());

    }
    @When("click Products button")
    public void click_products_button() {
        homePage.productsLink.click();
    }
    @When("hover over first product and click Add to cart")
    public void hover_over_first_product_and_click_add_to_cart() {
        ReusableMethods.hover(allProductsPage.firstProductAddToChart);
        ReusableMethods.clickWithJS(allProductsPage.firstProductAddToChart);
    }
    @When("click Continue Shopping button")
    public void click_continue_shopping_button() {
        allProductsPage.continueShoppingButton.click();
    }
    @When("hover over second product and click Add to cart")
    public void hover_over_second_product_and_click_add_to_cart() {
        ReusableMethods.hover(allProductsPage.secondProduct);
        ReusableMethods.clickWithJS(allProductsPage.secondProductAddToChart);
    }
    @When("click View Cart button")
    public void click_view_cart_button() {
        allProductsPage.viewCartButton.click();
    }
    @Then("verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        Assert.assertTrue(cartPage.twoProductsInCart.size()==2);
        Assert.assertTrue(cartPage.firstProductPrice.getText().equals(cartPage.firstProductTotal.getText()));
    }
    @Then("verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        Assert.assertTrue(cartPage.firstProductQuantity.getText().equals("1"));
    }

    @When("Click View Product for any product on home page")
    public void click_view_product_for_any_product_on_home_page() {
        allProductsPage.firstProductViewProductLink.click();
    }
    @Then("verify product detail is opened")
    public void verify_product_detail_is_opened() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals(ConfigReader.getProperty("productDetailPageTitle")));
    }
    @Then("increase quantity to {int}")
    public void increase_quantity_to(Integer int1) {
        productDetailsPage.quantity.clear();
        productDetailsPage.quantity.sendKeys("4");
    }
    @When("click Add to cart button")
    public void click_add_to_cart_button() {
        productDetailsPage.addToCart.click();
    }
    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        Assert.assertTrue(cartPage.firstProductInCart.isDisplayed());
        Assert.assertTrue(cartPage.firstProductQuantity.getText().equals("4"));
    }

    /*








     */
    @Then("enter product name in search input and click search button")
    public void enter_product_name_in_search_input_and_click_search_button() {
        Assert.assertTrue(allProductsPage.allProductsHeader.isDisplayed());
        allProductsPage.searchBox.sendKeys("top");
        allProductsPage.submitSearch.click();
    }
    @Then("verify SEARCHED PRODUCTS is visible")
    public void verify_searched_products_is_visible() {
        Assert.assertTrue(allProductsPage.searchedProductsExpression.isDisplayed());
    }
    @Then("verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        int count=0;
        for(WebElement each:allProductsPage.searchedProductList){
            if(each.getText().equalsIgnoreCase("top")){
                continue;
            }else{
                count++;
            }
        }
        if(count>0){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }
    //complete the following step and te assertion
    @Then("add those products to cart")
    public void add_those_products_to_cart() {
        Actions actions=new Actions(Driver.getDriver());

        //for(int i=0;i<=allProductsPage.searchedProductList.size()-1;i++){
        //    System.out.println(allProductsPage.searchedProductList.get(i).getText());
        //}
        for(int i=1;i<=allProductsPage.searchedProductList.size();i++){
            actions.moveToElement(allProductsPage.searchedProductList.get(i));
            allProductsPage.addAllProductsToCart.get(i-1).click();
            System.out.println(i);
            Driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            actions.doubleClick(allProductsPage.continueShoppingButton);
            ReusableMethods.waitFor(2);
        }
    }

    @Then("click Cart button and verify that products are visible in cart")
    public void click_cart_button_and_verify_that_products_are_visible_in_cart() {

    }

    @Then("verify Write Your Review is visible")
    public void verifyWriteYourReviewIsVisible() {
        Assert.assertTrue(productDetailsPage.writeYourReviewExpression.isDisplayed());
    }


    @And("enter name {string} email {string} and review {string}")
    public void enterNameEmailAndReview(String name, String email, String message) {
        productDetailsPage.name.sendKeys(name);
        productDetailsPage.email.sendKeys(email);
        productDetailsPage.review.sendKeys(message);
        productDetailsPage.reviewSubmitButton.click();
    }
    @When("click Submit button for review")
    public void clickSubmitButtonForReview() {
        productDetailsPage.reviewSubmitButton.click();
    }

    @Then("verify success message Thank you for your review.")
    public void verifySuccessMessageThankYouForYourReview() {
        Assert.assertTrue(productDetailsPage.thankYouForReviewMessage.isDisplayed());
    }



}
