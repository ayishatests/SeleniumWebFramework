package bdd.automation.steps;

import bdd.automation.context.TestContext;
import bdd.automation.domainobjects.Product;
import bdd.automation.pages.CartPage;
import bdd.automation.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

/**
 * CartSteps matches UI Elements on CartPage and their actions to one or more gherkin steps.
 * @author Ayisha YEO
 * @version  1.0
 */
public class CartSteps {
    private final CartPage cartPage;

    public CartSteps(TestContext context){
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    //Cart page steps
    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, Product product){
        Assert.assertEquals(product.getName(), cartPage.getProductName()); //Assert if product name  is what we expect
        Assert.assertEquals(quantity, cartPage.getProductQuantity()); //Assert if product quantity is what we expect
    }


}
