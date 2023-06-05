package bdd.automation.steps;

import bdd.automation.constants.EndPoint;
import bdd.automation.constants.MyConstants;
import bdd.automation.context.TestContext;
import bdd.automation.domainobjects.BillingDetails;
import bdd.automation.domainobjects.Product;
import bdd.automation.factory.DriverFactory;
import bdd.automation.pages.CartPage;
import bdd.automation.pages.CheckoutPage;
import bdd.automation.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 *  StepDef, code to link UI Elements actions to gherkin steps in scenarios features.
 * @Ayisha YEO
 * @version  1.0
 */
public class StepDef {
    private final WebDriver driver;
    private BillingDetails billingDetails;

    //Constructor
    public StepDef(TestContext context) {
        driver = context.driver; //we fetch driver which is already set in hooks
    }

}
