package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AllProductsPage;
import pages.DressCategoryPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ViewBrandProduct {

    AllProductsPage allProductsPage=new AllProductsPage();
    DressCategoryPage dressCategoryPage=new DressCategoryPage();

    @Then("verify that Brands are visible on left side bar")
    public void verify_that_brands_are_visible_on_left_side_bar() {
        Assert.assertTrue(allProductsPage.brandsHeader.isDisplayed());
    }

    @When("click on any brand name")
    public void click_on_any_brand_name() {
        allProductsPage.polo.click();
    }

    @Then("verify that user is navigated to brand page and brand products are displayed")
    public void verify_that_user_is_navigated_to_brand_page_and_brand_products_are_displayed() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("poloPageTitle")));
        Assert.assertTrue(dressCategoryPage.poloProductsExpression.isDisplayed());
    }

    @Then("on left side bar, click on any other brand link")
    public void on_left_side_bar_click_on_any_other_brand_link() {
        dressCategoryPage.hmBrandLink.click();
    }

    @Then("verify that user is navigated to that brand page and can see products")
    public void verify_that_user_is_navigated_to_that_brand_page_and_can_see_products() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("hmPageTitle")));
        Assert.assertTrue(dressCategoryPage.hmProductsExpression.isDisplayed());
    }


}
