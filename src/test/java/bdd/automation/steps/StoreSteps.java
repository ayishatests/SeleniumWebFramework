package bdd.automation.steps;

import bdd.automation.apis.CartApi;
import bdd.automation.constants.EndPoint;
import bdd.automation.context.TestContext;
import bdd.automation.domainobjects.Product;
import bdd.automation.pages.PageFactoryManager;
import bdd.automation.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * StoreSteps matches UI Elements on StorePage and their actions to one or more gherkin steps.
 * @author Ayisha YEO
 * @version  1.0
 */
public class StoreSteps {
    private final StorePage storePage;
    private TestContext context;

    public StoreSteps(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    //Store page steps
    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page(){
        storePage.load(EndPoint.STORE.url); //Common Web Action: Get Browser url
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product){
        storePage.addToCart(product.getName()); //Click on add to cart button & Click on view cart link
    }

    @And("I have a product in the cart")
    public void i_have_a_product_in_the_cart(){
        //cookie is empty because customer is a guest customer
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1); //cookie has value: we add product to cart
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
    }

}
