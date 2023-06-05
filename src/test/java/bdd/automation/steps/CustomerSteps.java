package bdd.automation.steps;

import bdd.automation.constants.MyConstants;
import bdd.automation.context.TestContext;
import bdd.automation.domainobjects.BillingDetails;
import bdd.automation.pages.PageFactoryManager;
import bdd.automation.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

/**
 * CustomerSteps matches UI Elements on CheckoutPage and their actions (relative to a customer) to one or more gherkin steps.
 * @author Ayisha YEO
 * @version  1.0
 */
public class CustomerSteps {
    private final StorePage storePage;
    private final TestContext context;

    public CustomerSteps(TestContext context){
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    //Customer steps
    @Given("I'm a guest customer")
    public void i_m_a_guest_customer(){
        //Common Web Action: Get Browser url
       storePage.load(MyConstants.STORE);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

}
