package bdd.automation.pages;

import bdd.automation.domainobjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * CheckoutPage class contain all the UI elements related to billing details, and the method to fill form and placing an order.
 * @author Ayisha YEO
 * @version 1.0
 */
public class CheckoutPage extends BasePage{
    @FindBy(id = "billing_first_name") private WebElement billingFirstnameFld;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropDown;
    @FindBy(id = "select2-billing_state-container") private WebElement alternateBillingStateDropDown;
    @FindBy(id = "billing_postcode") private WebElement billingZipFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    /**
     * BasePage(WebDriver driver)  constructor instantiates the webdriver driver, the WebDriverWait and the PageFactory.
     *
     * @param driver
     */
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * enterBillingFirstName() waits until element is visible, clears the field and sends 'billing FirstName' key
     * @param billingFirstName  (String)
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstnameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    /**
     * enterBillingLastName() waits until element is visible, clears the field and sends 'billing LastName' key
     * @param billingLastName (String)
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    /**
     * enterBillingAddressLineOne() waits until element is visible, clears the field and sends 'billing AddressLineOne' key in the particular field.
     * @param billingAddressLineOne (String)
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    /**
     * enterBillingCity() waits until element is visible, clears the field and sends 'billing City' Name in the particular field.
     * @param billingCity (String)
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    /**
     *  selectBillingState() waits until element is visible, selects 'billing state Name' in the dropdown list.
     * @param billingStateName (String)
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage selectBillingState(String billingStateName){
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + billingStateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }

    /**
     * enterBillingZip() waits until element is visible, clears the field and sends 'billing Zip' key in the particular field.
     * @param billingZip (String)
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    /**
     *  enterBillingEmail() waits until element is visible, clears the field and sends 'billing Email' key in the particular field.
     * @param billingEmail (String)
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    /**
     * Builder Pattern design pattern, initializes each UI elements action for billing detail.
     */
    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterBillingAddressLineOne(billingDetails.getBillingAddressOne()).
                enterBillingCity(billingDetails.getBillingCity()).
                selectBillingState(billingDetails.getBillingStateName()).
                enterBillingZip(billingDetails.getBillingZip()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }

    /**
     * placeOrder() click on place order button
     * @return this - instance of CheckoutPage
     */
    public CheckoutPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    /**
     * getNoticeTxt() gets the text displayed on the Checkout Page.
     * @return the particular text - (String).
     */
    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }
}
