package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.TestCasesPage;

public class VerifyTestCasesPageStepDef {

    HomePage homePage=new HomePage();
    TestCasesPage testCasesPage=new TestCasesPage();

    @When("click on Test Cases button")
    public void click_on_test_cases_button() {
        homePage.testCasesLink.click();
    }
    @Then("verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        Assert.assertTrue(testCasesPage.TestCasesHeader.isDisplayed());
    }
}
