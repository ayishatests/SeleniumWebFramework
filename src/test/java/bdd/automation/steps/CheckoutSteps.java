package bdd.automation.steps;

import bdd.automation.constants.EndPoint;
import bdd.automation.context.TestContext;
import bdd.automation.pages.CheckoutPage;
import bdd.automation.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * CheckoutSteps matches UI Elements on CheckoutPage and their actions to one or more gherkin steps.
 * @author Ayisha YEO
 * @version  1.0
 */
public class CheckoutSteps {
    private final CheckoutPage checkoutPage;
    private final TestContext context;

    public CheckoutSteps(TestContext context){
        this.context = context;
        checkoutPage = PageFactoryManager.getCheckoutPage(context.driver);
    }

    // Checkout page steps
    @When("I provide billing details")
    public void i_provide_billing_details(){
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place an order")
    public void i_place_an_order() throws InterruptedException {
       checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully(){
        //Assert if notice text is what we expect
        Assert.assertEquals("Thank you. Your order has been received.",
                checkoutPage.getNotice());
    }

    @And("I'm on the Checkout page")
    public void i_m_on_the_checkout_page(){
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }

}
