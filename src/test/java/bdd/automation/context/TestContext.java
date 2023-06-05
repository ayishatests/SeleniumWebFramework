package bdd.automation.context;

import bdd.automation.domainobjects.BillingDetails;
import bdd.automation.domainobjects.Cookies;
import org.openqa.selenium.WebDriver;
/**
 * TestContext class, contains generic utils and parameters that you want to share
 *  among the classes.
 *  Here, we set Application State using API.
 * @author Ayisha YEO
 * @version 1.0
 */
public class TestContext {

    public WebDriver driver;
    public BillingDetails billingDetails;

    public Cookies cookies;

    public TestContext(){
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
    }

}
